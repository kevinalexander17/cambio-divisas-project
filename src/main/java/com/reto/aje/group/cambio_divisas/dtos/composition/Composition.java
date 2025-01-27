package com.reto.aje.group.cambio_divisas.dtos.composition;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Composition<T extends Serializable, R extends Serializable> implements Serializable {
    private static final long serialVersionUID = -1978623290658332411L;
    private T request;
    private R response;
}
