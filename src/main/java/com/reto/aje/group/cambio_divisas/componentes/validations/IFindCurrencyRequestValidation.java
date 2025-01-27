package com.reto.aje.group.cambio_divisas.componentes.validations;

import com.reto.aje.group.cambio_divisas.componentes.CommonValidationResult;
import com.reto.aje.group.cambio_divisas.componentes.enums.CommonProcessResult;
import com.reto.aje.group.cambio_divisas.componentes.utils.CommonHelper;
import com.reto.aje.group.cambio_divisas.dtos.request.currency.FindCurrencyRequest;

import java.util.ArrayList;
import java.util.function.Function;

@FunctionalInterface
public interface IFindCurrencyRequestValidation extends Function<FindCurrencyRequest, CommonValidationResult> {
    static IFindCurrencyRequestValidation validate() {
        return findCurrencyRequest -> {
            final CommonValidationResult commonValidationResult = CommonValidationResult.builder()
                    .commonProcessResult(CommonProcessResult.PROCESS_SUCCESSFULLY_COMPLETED)
                    .errors(new ArrayList<>())
                    .build();
            CommonHelper.doOnValidateRequiredField("body request", findCurrencyRequest, commonValidationResult);
            if (!commonValidationResult.getErrors().isEmpty()) return commonValidationResult;

            CommonHelper.doOnValidateRequiredField("currencyCode", findCurrencyRequest.getCurrencyCode(), commonValidationResult);
            if (!commonValidationResult.getErrors().isEmpty()) return commonValidationResult;

            return commonValidationResult;
        };
    }


}
