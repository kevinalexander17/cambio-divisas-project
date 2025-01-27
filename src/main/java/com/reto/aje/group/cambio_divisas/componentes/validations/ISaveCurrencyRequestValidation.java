package com.reto.aje.group.cambio_divisas.componentes.validations;

import com.reto.aje.group.cambio_divisas.componentes.CommonValidationResult;
import com.reto.aje.group.cambio_divisas.componentes.enums.CommonProcessResult;
import com.reto.aje.group.cambio_divisas.componentes.utils.CommonHelper;
import com.reto.aje.group.cambio_divisas.dtos.request.currency.SaveCurrencyRequest;

import java.util.ArrayList;
import java.util.function.Function;

@FunctionalInterface
public interface ISaveCurrencyRequestValidation extends Function<SaveCurrencyRequest, CommonValidationResult> {
    static ISaveCurrencyRequestValidation validate() {
        return saveCurrencyRequest -> {
            final CommonValidationResult commonValidationResult = CommonValidationResult.builder()
                    .commonProcessResult(CommonProcessResult.PROCESS_SUCCESSFULLY_COMPLETED)
                    .errors(new ArrayList<>())
                    .build();

            CommonHelper.doOnValidateRequiredField("body request", saveCurrencyRequest, commonValidationResult);
            if (!commonValidationResult.getErrors().isEmpty()) return commonValidationResult;

            CommonHelper.doOnValidateRequiredField("currencyCode", saveCurrencyRequest.getCurrencyCode(), commonValidationResult);
            if (!commonValidationResult.getErrors().isEmpty()) return commonValidationResult;

            CommonHelper.doOnValidateRequiredField("description", saveCurrencyRequest.getDescription(), commonValidationResult);
            if (!commonValidationResult.getErrors().isEmpty()) return commonValidationResult;

            return commonValidationResult;
        };

    }
}
