package com.reto.aje.group.cambio_divisas.dtos.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseDomain implements Serializable {
    private static final long serialVersionUID = -8723598483115131233L;
    private Long id;
    private String uuid;
    private Date createdAt;
    private Date updatedAt;
}
