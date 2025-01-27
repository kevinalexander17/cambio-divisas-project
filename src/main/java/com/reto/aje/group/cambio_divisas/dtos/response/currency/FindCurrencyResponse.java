package com.reto.aje.group.cambio_divisas.dtos.response.currency;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FindCurrencyResponse implements Serializable {
    private static final long serialVersionUID = -1531246858351725982L;

    @JsonProperty("id")
    @JsonbProperty("id")
    private String id;

    @JsonProperty("code")
    @JsonbProperty("code")
    private String code;

    @JsonProperty("description")
    @JsonbProperty("description")
    private String description;
}
