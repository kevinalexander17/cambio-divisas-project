package com.reto.aje.group.cambio_divisas.dtos.response.currency;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyResponse implements Serializable {
    private static final long serialVersionUID = -1531246858351725982L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("code")
    private String code;

    @JsonProperty("description")
    private String description;
}
