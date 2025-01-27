package com.reto.aje.group.cambio_divisas.dtos.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@EqualsAndHashCode(callSuper = true)
public class CurrencyExchangeException extends CommonBusinessProcessException{
    private static final long serialVersionUID = 2045191598630440138L;

    private final HttpStatus httpStatus;
    private final List<String> errors;

    public CurrencyExchangeException(String message, HttpStatus httpStatus, List<String> errors) {
        super(message);
        this.httpStatus = httpStatus;
        this.errors = errors;
    }
    public CurrencyExchangeException(String message, Throwable cause, HttpStatus httpStatus, List<String> errors) {
        super(message, cause);
        this.httpStatus = httpStatus;
        this.errors = errors;
    }
}
