package com.reto.aje.group.cambio_divisas.repositories.implementation.database.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CD_EXCHANGE_RATE")
public class ExchangeRateEntity {

    @Id
    @Column("ER_ID")
    private Long erId;

    @Column("ER_UUID")
    private String erUuid;

    @Column("ER_CURR_FROM")
    private Long erCurrFrom;

    @Column("ER_CURR_TO")
    private Long erCurrTo;

    @Column("ER_BUY_RATE")
    private Double erBuyRate;

    @Column("ER_SELL_RATE")
    private Double erSellRate;

    @CreatedDate
    @Column("ER_CREATED_AT")
    private LocalDateTime erCreatedAt;

    @LastModifiedDate
    @Column("ER_UPDATED_AT")
    private LocalDateTime erUpdatedAt;
}
