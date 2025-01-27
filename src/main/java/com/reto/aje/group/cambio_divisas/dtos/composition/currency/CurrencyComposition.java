package com.reto.aje.group.cambio_divisas.dtos.composition.currency;

import com.reto.aje.group.cambio_divisas.dtos.composition.Composition;
import com.reto.aje.group.cambio_divisas.dtos.request.currency.CurrencyRequest;
import com.reto.aje.group.cambio_divisas.dtos.response.currency.CurrencyResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@AllArgsConstructor
@SuperBuilder
public class CurrencyComposition extends Composition<CurrencyRequest, CurrencyResponse> {
    private static final long serialVersionUID = -463204239580455428L;
}
