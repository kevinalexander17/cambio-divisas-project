package com.reto.aje.group.cambio_divisas.repositories.implementation.database;

import com.reto.aje.group.cambio_divisas.componentes.mapper.entity.ICurrencyEntityMapper;
import com.reto.aje.group.cambio_divisas.dtos.domain.Currency;
import com.reto.aje.group.cambio_divisas.dtos.exceptions.NotDomainFoundException;
import com.reto.aje.group.cambio_divisas.repositories.contracts.ICurrencyRepository;
import com.reto.aje.group.cambio_divisas.repositories.implementation.database.r2dbc.ICurrencyEntityRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Repository
public class CurrencyRepository implements ICurrencyRepository {
    private final ICurrencyEntityRepository iCurrencyEntityRepository;
    private final ICurrencyEntityMapper iCurrencyEntityMapper;

    public CurrencyRepository(ICurrencyEntityRepository iCurrencyEntityRepository, ICurrencyEntityMapper iCurrencyEntityMapper) {
        this.iCurrencyEntityRepository = iCurrencyEntityRepository;
        this.iCurrencyEntityMapper = iCurrencyEntityMapper;
    }

    @Override
    public Mono<Currency> doOnFetchCurrencyByCode(final String code) {
        return iCurrencyEntityRepository.doOnFindByCode(code)
                .switchIfEmpty(Mono.error(() -> {
                    List<String> errors = new ArrayList<>();
                    String error = String.format("Currency %s not found", code);
                    errors.add(error);
                    log.error(error);
                    return new NotDomainFoundException(error, HttpStatus.BAD_REQUEST, errors);
                }))
                .map(iCurrencyEntityMapper::toDomain);
    }

}