package com.reto.aje.group.cambio_divisas.dtos.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GenericBusinessResponse<T>  implements Serializable {

    private static final long serialVersionUID = 4528173490083820421L;

    @JsonProperty("data")
    private T data;
}
