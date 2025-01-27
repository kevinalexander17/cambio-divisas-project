package com.reto.aje.group.cambio_divisas.repositories.implementation.database.r2dbc;


import com.reto.aje.group.cambio_divisas.repositories.implementation.database.entities.CurrencyEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ICurrencyEntityRepository extends R2dbcRepository<CurrencyEntity, Long> {


    @Query("SELECT * FROM CURRENCY WHERE CU_CODE = :code")
    Mono<CurrencyEntity> doOnFindByCode(final String code);

}
