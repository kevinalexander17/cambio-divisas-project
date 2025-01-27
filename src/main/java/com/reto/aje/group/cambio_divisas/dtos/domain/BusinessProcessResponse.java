package com.reto.aje.group.cambio_divisas.dtos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.reto.aje.group.cambio_divisas.dtos.exceptions.CurrencyExchangeException;
import lombok.*;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BusinessProcessResponse {

    @JsonbProperty("code")
    @JsonProperty("code")
    private String code;

    @JsonbProperty("message")
    @JsonProperty("message")
    private String message;


    @JsonFormat(
            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    )
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonbProperty("datetime")
    @JsonProperty("datetime")
    private Date datetime;

    @JsonProperty("data")
    private Serializable data;

    @JsonProperty("errors")
    private List<String> errors;

    public static BusinessProcessResponse doOnBuildEntitySuccessfullyResponse(final Serializable data) {
        return builder()
                .code("200")
                .message("Proceso exitoso.")
                .datetime(new Date())
                .data(data)
                .build();
    }

    public static BusinessProcessResponse doOnBuildEmptySuccessfullyResponse() {
        return builder()
                .code("200")
                .message("Proceso exitoso.")
                .datetime(new Date())
                .build();
    }


    public static BusinessProcessResponse doOnBuildErrorResponse(final CurrencyExchangeException exception) {
        return BusinessProcessResponse.builder()
                .code(String.valueOf(exception.getHttpStatus().value()))
                .message(exception.getMessage())
                .datetime(new Date())
                .errors(exception.getErrors())
                .build();
    }


}
