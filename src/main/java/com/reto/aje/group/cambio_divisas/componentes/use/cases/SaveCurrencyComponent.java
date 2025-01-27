package com.reto.aje.group.cambio_divisas.componentes.use.cases;

import com.reto.aje.group.cambio_divisas.componentes.enums.CommonProcessResult;
import com.reto.aje.group.cambio_divisas.componentes.mapper.dto.IFindCurrencyMapper;
import com.reto.aje.group.cambio_divisas.componentes.validations.ISaveCurrencyRequestValidation;
import com.reto.aje.group.cambio_divisas.constants.LogConstants;
import com.reto.aje.group.cambio_divisas.dtos.composition.currency.SaveCurrencyComposition;
import com.reto.aje.group.cambio_divisas.dtos.domain.BusinessProcessResponse;
import com.reto.aje.group.cambio_divisas.dtos.exceptions.CurrencyException;
import com.reto.aje.group.cambio_divisas.dtos.request.currency.SaveCurrencyRequest;
import com.reto.aje.group.cambio_divisas.services.contracts.currency.exchange.ICurrencyDomainService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Log4j2
@Component
public class SaveCurrencyComponent {
    private final ICurrencyDomainService iCurrencyDomainService;
    private final IFindCurrencyMapper iFindCurrencyMapper;

    private static final String DO_ON_VALIDATE_REQUEST = "doOnValidateRequest";
    private static final String DO_ON_EXECUTE = "doOnExecuteSaveCurrency";
    private static final String DO_ON_PROCESS_RESPONSE = "doOnProcessResponse";


    public SaveCurrencyComponent(ICurrencyDomainService iCurrencyDomainService, IFindCurrencyMapper iFindCurrencyMapper) {
        this.iCurrencyDomainService = iCurrencyDomainService;
        this.iFindCurrencyMapper = iFindCurrencyMapper;
    }

    public Mono<BusinessProcessResponse> doOnSaveCurrency(final SaveCurrencyRequest saveCurrencyRequest) {
        return doOnCreateComposition(saveCurrencyRequest)
                .flatMap(this::doOnValidateRequest)
                .flatMap(this::doOnExecuteSaveCurrency)
                .flatMap(this::doOnProcessResponse);
    }

    private Mono<SaveCurrencyComposition> doOnCreateComposition(final SaveCurrencyRequest saveCurrencyRequest) {
        return Mono.just(saveCurrencyRequest)
                .flatMap(current -> {
                    SaveCurrencyComposition saveCurrencyComposition = new SaveCurrencyComposition();
                    saveCurrencyComposition.setRequest(current);
                    return Mono.just(saveCurrencyComposition);
                });
    }

    private Mono<SaveCurrencyComposition> doOnValidateRequest(final SaveCurrencyComposition saveCurrencyComposition) {
        return Mono.fromSupplier(() -> ISaveCurrencyRequestValidation.validate().apply(saveCurrencyComposition.getRequest()))
                .flatMap(commonValidationResult -> {
                    if (CommonProcessResult.PROCESS_FAILED.equals(commonValidationResult.getCommonProcessResult())) {
                        log.error("error in process {}, errors: {}", DO_ON_VALIDATE_REQUEST, commonValidationResult.getErrors());
                        return Mono.error(() -> new CurrencyException("Error in Validate Currency Request", HttpStatus.BAD_REQUEST, commonValidationResult.getErrors()));
                    }
                    return Mono.just(saveCurrencyComposition);
                })
                .doOnSuccess(success -> log.debug(LogConstants.SUCCESS_TRACE_LOG_FORMAT, DO_ON_VALIDATE_REQUEST, success.toString()))
                .doOnError(throwable -> log.error(LogConstants.ERROR_TRACE_LOG_FORMAT, DO_ON_VALIDATE_REQUEST, throwable.getMessage()));
    }

    private Mono<SaveCurrencyComposition> doOnExecuteSaveCurrency(final SaveCurrencyComposition saveCurrencyComposition) {
        return iCurrencyDomainService.doOnSaveOrUpdate(iFindCurrencyMapper.fromRequest(saveCurrencyComposition.getRequest()))
                .flatMap(currency -> {
                    saveCurrencyComposition.setResponse(iFindCurrencyMapper.toDtoResponse(currency));
                    return Mono.just(saveCurrencyComposition);
                })
                .doOnSuccess(success -> log.debug(LogConstants.SUCCESS_TRACE_LOG_FORMAT, DO_ON_EXECUTE, success.toString()))
                .doOnError(throwable -> log.error(LogConstants.ERROR_TRACE_LOG_FORMAT, DO_ON_EXECUTE, throwable.getMessage()));
    }

    private Mono<BusinessProcessResponse> doOnProcessResponse(final SaveCurrencyComposition saveCurrencyComposition) {
        return Mono.just(saveCurrencyComposition)
                .flatMap(current -> Mono.just(BusinessProcessResponse.doOnBuildEmptySuccessfullyResponse()))
                .doOnSuccess(success -> log.debug(LogConstants.SUCCESS_TRACE_LOG_FORMAT, DO_ON_PROCESS_RESPONSE, success.toString()))
                .doOnError(throwable -> log.debug(LogConstants.ERROR_TRACE_LOG_FORMAT, DO_ON_PROCESS_RESPONSE, throwable.getMessage()))
                .log();

    }
}
