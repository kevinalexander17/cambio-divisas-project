package com.reto.aje.group.cambio_divisas.dtos.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class CommonBusinessProcessException extends RuntimeException {
    private static final long serialVersionUID = 5100904425953775481L;

    public CommonBusinessProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonBusinessProcessException(String message) {
        super(message);
    }
}
