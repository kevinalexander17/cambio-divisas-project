package com.reto.aje.group.cambio_divisas.dtos.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@EqualsAndHashCode(callSuper = true)
public class NotDomainFoundException extends CurrencyExchangeException{
    private static final long serialVersionUID = 5242157454092459778L;

    public NotDomainFoundException(String message, HttpStatus httpStatus, List<String> errors) {
        super(message, httpStatus, errors);
    }

    public NotDomainFoundException(String message, Throwable cause, HttpStatus httpStatus, List<String> errors) {
        super(message, cause, httpStatus, errors);
    }
}
