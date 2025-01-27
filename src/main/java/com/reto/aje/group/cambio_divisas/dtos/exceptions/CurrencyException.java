package com.reto.aje.group.cambio_divisas.dtos.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@EqualsAndHashCode(callSuper = true)
public class CurrencyException extends CurrencyExchangeException{
    private static final long serialVersionUID = 671863719371269313L;

    public CurrencyException(String message, HttpStatus httpStatus, List<String> errors) {
        super(message, httpStatus, errors);
    }
    public CurrencyException(String message, Throwable cause, HttpStatus httpStatus, List<String> errors) {
        super(message, cause, httpStatus, errors);
    }
}
