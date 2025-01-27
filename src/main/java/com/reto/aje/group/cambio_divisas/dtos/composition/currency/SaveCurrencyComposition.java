package com.reto.aje.group.cambio_divisas.dtos.composition.currency;

import com.reto.aje.group.cambio_divisas.dtos.composition.Composition;
import com.reto.aje.group.cambio_divisas.dtos.request.currency.SaveCurrencyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@SuperBuilder
public class SaveCurrencyComposition extends Composition<SaveCurrencyRequest, Serializable> {
    private static final long serialVersionUID = -5806051403620197928L;
}
