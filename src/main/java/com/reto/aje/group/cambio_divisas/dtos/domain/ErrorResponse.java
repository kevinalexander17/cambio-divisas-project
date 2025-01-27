package com.reto.aje.group.cambio_divisas.dtos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse extends BaseBusinessResponse implements Serializable {
    private static final long serialVersionUID = -8825588961099627834L;
    private String errorMessage;
}
