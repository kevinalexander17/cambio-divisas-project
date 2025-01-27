package com.reto.aje.group.cambio_divisas.dtos.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.modelmapper.spi.ErrorMessage;

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

    @JsonProperty("data")
    private GenericBusinessResponse<Serializable> data;

    @JsonProperty("errors")
    private List<ErrorMessage> errors;

    // Constructor para respuesta exitosa

    //setEntitySuccessfullyResponse ---> proceso ok y tiene body
    //setEmptySuccessfullyResponse ---> proceso ok y no tiene body
    //seErrorResponse ---> proceso falló y tiene body





}
