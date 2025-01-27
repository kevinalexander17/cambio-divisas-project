package com.reto.aje.group.cambio_divisas.componentes;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.reto.aje.group.cambio_divisas.componentes.enums.CommonProcessResult;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonValidationResult implements Serializable {
    private static final long serialVersionUID = 5881439253404933803L;

    private CommonProcessResult commonProcessResult;
    private List<String> errors;
}
