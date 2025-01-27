package com.reto.aje.group.cambio_divisas.controllers.contracts;

import com.reto.aje.group.cambio_divisas.dtos.domain.BusinessProcessResponse;
import com.reto.aje.group.cambio_divisas.dtos.request.currency.SaveCurrencyRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

public interface ICurrencyController {

    Mono<ResponseEntity<BusinessProcessResponse>> doOnFindCurrencyByCode(@RequestParam(name = "currencyCode") String currencyCode);
    Mono<ResponseEntity<BusinessProcessResponse>> doOnSaveCurrency(@RequestBody SaveCurrencyRequest saveCurrencyRequest);
}
