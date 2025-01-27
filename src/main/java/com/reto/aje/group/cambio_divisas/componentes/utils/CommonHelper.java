package com.reto.aje.group.cambio_divisas.componentes.utils;

import com.reto.aje.group.cambio_divisas.componentes.CommonValidationResult;
import com.reto.aje.group.cambio_divisas.componentes.enums.CommonProcessResult;
import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class CommonHelper {

    public void doOnValidateRequiredField(final String field,
                                                  final Object value,
                                                  final CommonValidationResult commonValidationResult) {
        if (Objects.isNull(value)) {
            commonValidationResult.getErrors().add(String.format("Field: %s is required, it must be not empty or blank", field));
            commonValidationResult.setCommonProcessResult(CommonProcessResult.PROCESS_FAILED);
        }
    }
}
