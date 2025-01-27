package com.reto.aje.group.cambio_divisas.dtos.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GenericBusinessResponse <T> extends BaseBusinessResponse implements Serializable {

    private static final long serialVersionUID = 4528173490083820421L;

    @JsonProperty("data")
    private T data;
}
