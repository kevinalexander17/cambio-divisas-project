package com.reto.aje.group.cambio_divisas.componentes.mapper.entity;

import com.reto.aje.group.cambio_divisas.dtos.domain.Currency;
import com.reto.aje.group.cambio_divisas.repositories.implementation.database.entities.CurrencyEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface ICurrencyEntityMapper {

    @Mapping(source = "id", target = "cuId")
    @Mapping(source = "uuid", target = "cuUuid")
    @Mapping(source = "code", target = "cuCode")
    @Mapping(source = "description", target = "cuDesc")
    @Mapping(source = "createdAt", target = "cuCreatedAt")
    @Mapping(source = "updatedAt", target = "cuUpdatedAt")
    CurrencyEntity toEntity(Currency currencyDomain);

    @InheritInverseConfiguration(name = "toEntity")
    Currency toDomain(CurrencyEntity currencyEntity);
}
