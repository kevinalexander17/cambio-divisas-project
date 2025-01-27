package com.reto.aje.group.cambio_divisas.services.implementations.currency.exchange;

import com.reto.aje.group.cambio_divisas.dtos.domain.Currency;
import com.reto.aje.group.cambio_divisas.repositories.contracts.ICurrencyRepository;
import com.reto.aje.group.cambio_divisas.services.contracts.currency.exchange.ICurrencyDomainService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Log4j2
@Service
public class CurrencyDomainService implements ICurrencyDomainService {
    private final ICurrencyRepository iCurrencyRepository;

    public CurrencyDomainService(ICurrencyRepository iCurrencyRepository) {
        this.iCurrencyRepository = iCurrencyRepository;
    }

    @Override
    public Mono<Currency> doOnFindByCode(final String code) {
        return iCurrencyRepository.doOnFetchCurrencyByCode(code);
    }

    @Override
    public Mono<Currency> doOnSaveOrUpdate(final Currency currency) {
        return Mono.just(currency)
                .flatMap(current -> {
                    current.setUuid(UUID.randomUUID().toString());
                    return iCurrencyRepository.doOnSaveOrUpdate(currency);
                });
    }
}
