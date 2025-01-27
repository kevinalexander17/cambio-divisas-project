package com.reto.aje.group.cambio_divisas.componentes.mapper.dto;

import com.reto.aje.group.cambio_divisas.dtos.domain.Currency;
import com.reto.aje.group.cambio_divisas.dtos.request.currency.SaveCurrencyRequest;
import com.reto.aje.group.cambio_divisas.dtos.response.currency.FindCurrencyResponse;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface IFindCurrencyMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    FindCurrencyResponse toDtoResponse(Currency currency);

    @Mapping(source = "currencyCode", target = "code")
    @Mapping(source = "description", target = "description")
    Currency fromRequest(SaveCurrencyRequest saveCurrencyRequest);
}
