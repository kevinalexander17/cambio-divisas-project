package com.reto.aje.group.cambio_divisas.dtos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Currency extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -5858416720688468250L;

    private String code;
    private String description;
}
