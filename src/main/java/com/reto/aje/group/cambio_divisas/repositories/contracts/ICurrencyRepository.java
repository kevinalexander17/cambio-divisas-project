package com.reto.aje.group.cambio_divisas.repositories.contracts;

import com.reto.aje.group.cambio_divisas.dtos.domain.Currency;
import reactor.core.publisher.Mono;

public interface ICurrencyRepository {

    Mono<Currency> doOnFetchCurrencyByCode(final String code);
    Mono<Currency> doOnSaveOrUpdate(final Currency currency);
}
