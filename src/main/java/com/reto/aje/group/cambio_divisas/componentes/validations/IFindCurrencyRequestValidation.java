package com.reto.aje.group.cambio_divisas.componentes.validations;

import com.reto.aje.group.cambio_divisas.componentes.CommonValidationResult;
import com.reto.aje.group.cambio_divisas.componentes.enums.CommonProcessResult;
import com.reto.aje.group.cambio_divisas.dtos.request.currency.CurrencyRequest;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface IFindCurrencyRequestValidation extends Function<CurrencyRequest, CommonValidationResult> {
    static IFindCurrencyRequestValidation validate() {
        return request -> {
            final CommonValidationResult commonValidationResult = CommonValidationResult.builder()
                    .commonProcessResult(CommonProcessResult.PROCESS_SUCCESSFULLY_COMPLETED)
                    .errors(new ArrayList<>())
                    .build();
            doOnValidateRequiredField("body request", request, commonValidationResult);
            if (!commonValidationResult.getErrors().isEmpty()) return commonValidationResult;

            doOnValidateRequiredField("currencyCode", request.getCurrencyCode(), commonValidationResult);
            if (!commonValidationResult.getErrors().isEmpty()) return commonValidationResult;

            return commonValidationResult;
        };
    }

    private static void doOnValidateRequiredField(final String field,
                                                  final Object value,
                                                  final CommonValidationResult commonValidationResult) {
        if (Objects.isNull(value)) {
            commonValidationResult.getErrors().add(String.format("Field: %s is required, it must be not empty or blank", field));
            commonValidationResult.setCommonProcessResult(CommonProcessResult.PROCESS_FAILED);
        }
    }
}
