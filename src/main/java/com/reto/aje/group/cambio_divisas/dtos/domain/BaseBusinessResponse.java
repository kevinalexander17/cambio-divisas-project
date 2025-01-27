package com.reto.aje.group.cambio_divisas.dtos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseBusinessResponse implements Serializable {
    private static final long serialVersionUID = -3969695971778534995L;
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

}
