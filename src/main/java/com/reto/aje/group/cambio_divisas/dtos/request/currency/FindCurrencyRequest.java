package com.reto.aje.group.cambio_divisas.dtos.request.currency;

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
public class FindCurrencyRequest implements Serializable {
    private static final long serialVersionUID = 7203345893494382102L;

    @JsonProperty("currencyCode")
    @JsonbProperty("currencyCode")
    private String currencyCode;

}
