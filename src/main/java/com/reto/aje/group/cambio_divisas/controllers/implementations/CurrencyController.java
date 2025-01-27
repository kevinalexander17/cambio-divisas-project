package com.reto.aje.group.cambio_divisas.controllers.implementations;

import com.reto.aje.group.cambio_divisas.componentes.use.cases.FindCurrencyComponent;
import com.reto.aje.group.cambio_divisas.controllers.contracts.ICurrencyController;
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
    public Mono<ResponseEntity<Object>> doOnFindCurrencyByCode(@RequestParam(name="currencyCode") String currencyCode) {
        return null;
    }
}
