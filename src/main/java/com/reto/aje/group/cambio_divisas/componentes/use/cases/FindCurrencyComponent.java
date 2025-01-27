package com.reto.aje.group.cambio_divisas.componentes.use.cases;


import com.reto.aje.group.cambio_divisas.componentes.enums.CommonProcessResult;
import com.reto.aje.group.cambio_divisas.componentes.mapper.dto.IFindCurrencyMapper;
import com.reto.aje.group.cambio_divisas.componentes.validations.IFindCurrencyRequestValidation;
import com.reto.aje.group.cambio_divisas.constants.LogConstants;
import com.reto.aje.group.cambio_divisas.dtos.composition.currency.CurrencyComposition;
import com.reto.aje.group.cambio_divisas.dtos.domain.BusinessProcessResponse;
import com.reto.aje.group.cambio_divisas.dtos.exceptions.CurrencyException;
import com.reto.aje.group.cambio_divisas.dtos.request.currency.CurrencyRequest;
import com.reto.aje.group.cambio_divisas.services.contracts.currency.exchange.ICurrencyDomainService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Log4j2
@Component
public class FindCurrencyComponent {
    private final ICurrencyDomainService iCurrencyDomainService;
    private final IFindCurrencyMapper iFindCurrencyMapper;

    private static final String DO_ON_VALIDATE_REQUEST = "doOnValidateRequest";
    private static final String DO_ON_EXECUTE = "doOnExecuteFindCurrency";
    private static final String DO_ON_PROCESS_RESPONSE = "doOnProcessResponse";


    public FindCurrencyComponent(ICurrencyDomainService iCurrencyDomainService, IFindCurrencyMapper iFindCurrencyMapper) {
        this.iCurrencyDomainService = iCurrencyDomainService;
        this.iFindCurrencyMapper = iFindCurrencyMapper;
    }

    public Mono<BusinessProcessResponse> doOnFindCurrencyByCode(final CurrencyRequest currencyRequest) {
        return doOnCreateComposition(currencyRequest)
                .flatMap(this::doOnValidateRequest)
                .flatMap(this::doOnExecuteFindCurrency)
                .flatMap(this::doOnProcessResponse);
    }

    private Mono<CurrencyComposition> doOnCreateComposition(final CurrencyRequest currencyRequest) {
        return Mono.just(currencyRequest)
                .flatMap(current -> {
                    CurrencyComposition currencyComposition = new CurrencyComposition();
                    currencyComposition.setRequest(current);
                    return Mono.just(currencyComposition);
                });
    }

    private Mono<CurrencyComposition> doOnValidateRequest(final CurrencyComposition currencyComposition) {
        return Mono.fromSupplier(() -> IFindCurrencyRequestValidation.validate().apply(currencyComposition.getRequest()))
                .flatMap(commonValidationResult -> {
                    if (CommonProcessResult.PROCESS_FAILED.equals(commonValidationResult.getCommonProcessResult())) {
                        log.error("error in process {}, errors: {}", DO_ON_VALIDATE_REQUEST, commonValidationResult.getErrors());
                        return Mono.error(() -> new CurrencyException("Error in Validate Currency Request", HttpStatus.BAD_REQUEST, commonValidationResult.getErrors()));
                    }
                    return Mono.just(currencyComposition);
                })
                .doOnSuccess(success -> log.debug(LogConstants.SUCCESS_TRACE_LOG_FORMAT, DO_ON_VALIDATE_REQUEST, success.toString()))
                .doOnError(throwable -> log.error(LogConstants.ERROR_TRACE_LOG_FORMAT, DO_ON_VALIDATE_REQUEST, throwable.getMessage()));
    }

    private Mono<CurrencyComposition> doOnExecuteFindCurrency(final CurrencyComposition currencyComposition) {
        return iCurrencyDomainService.doOnFindByCode(currencyComposition.getRequest().getCurrencyCode())
                .flatMap(currency -> {
                    currencyComposition.setResponse(iFindCurrencyMapper.toDto(currency));
                    return Mono.just(currencyComposition);
                })
                .doOnSuccess(success -> log.debug(LogConstants.SUCCESS_TRACE_LOG_FORMAT, DO_ON_EXECUTE, success.toString()))
                .doOnError(throwable -> log.error(LogConstants.ERROR_TRACE_LOG_FORMAT, DO_ON_EXECUTE, throwable.getMessage()));
    }

    private Mono<BusinessProcessResponse> doOnProcessResponse(final CurrencyComposition currencyComposition) {
        return Mono.just(currencyComposition)
                .flatMap(current -> Mono.just(BusinessProcessResponse.doOnBuildEntitySuccessfullyResponse(current.getResponse())))
                .doOnSuccess(success -> log.debug(LogConstants.SUCCESS_TRACE_LOG_FORMAT, DO_ON_PROCESS_RESPONSE, success.toString()))
                .doOnError(throwable -> log.debug(LogConstants.ERROR_TRACE_LOG_FORMAT, DO_ON_PROCESS_RESPONSE, throwable.getMessage()))
                .log();

    }
}
