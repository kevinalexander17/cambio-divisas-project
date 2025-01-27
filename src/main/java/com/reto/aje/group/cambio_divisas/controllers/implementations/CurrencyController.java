package com.reto.aje.group.cambio_divisas.controllers.implementations;

import com.reto.aje.group.cambio_divisas.componentes.use.cases.FindCurrencyComponent;
import com.reto.aje.group.cambio_divisas.controllers.contracts.ICurrencyController;
import com.reto.aje.group.cambio_divisas.dtos.domain.BusinessProcessResponse;
import com.reto.aje.group.cambio_divisas.dtos.exceptions.CurrencyExchangeException;
import com.reto.aje.group.cambio_divisas.dtos.request.currency.CurrencyRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequestMapping(name = "/currency",produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyController implements ICurrencyController {

    private final FindCurrencyComponent findCurrencyComponent;

    public CurrencyController(FindCurrencyComponent findCurrencyComponent) {
        this.findCurrencyComponent = findCurrencyComponent;
    }

    @GetMapping(path = "/find")
    @Override
    public Mono<ResponseEntity<BusinessProcessResponse>> doOnFindCurrencyByCode(@RequestParam(name="currencyCode") String currencyCode) {
        CurrencyRequest currencyRequest = CurrencyRequest.builder().currencyCode(currencyCode).build();
        return findCurrencyComponent.doOnFindCurrencyByCode(currencyRequest)
                .map(ResponseEntity::ok)
                .onErrorResume(CurrencyExchangeException.class, exception -> {
                    BusinessProcessResponse erroBusinessProcessResponse = BusinessProcessResponse.doOnBuildErrorResponse(exception);
                    return Mono.just(ResponseEntity.status(Integer.parseInt(erroBusinessProcessResponse.getCode()))
                            .body(erroBusinessProcessResponse));
                });
    }
}
