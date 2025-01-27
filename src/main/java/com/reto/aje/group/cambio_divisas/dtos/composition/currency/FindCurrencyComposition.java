package com.reto.aje.group.cambio_divisas.dtos.composition.currency;

import com.reto.aje.group.cambio_divisas.dtos.composition.Composition;
import com.reto.aje.group.cambio_divisas.dtos.request.currency.FindCurrencyRequest;
import com.reto.aje.group.cambio_divisas.dtos.response.currency.FindCurrencyResponse;
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
public class FindCurrencyComposition extends Composition<FindCurrencyRequest, FindCurrencyResponse> {
    private static final long serialVersionUID = -463204239580455428L;
}
