package com.reto.aje.group.cambio_divisas.services.contracts.currency.exchange;

import com.reto.aje.group.cambio_divisas.dtos.domain.Currency;
import reactor.core.publisher.Mono;

public interface ICurrencyDomainService {
    Mono<Currency> doOnFindByCode(final String code);
}
