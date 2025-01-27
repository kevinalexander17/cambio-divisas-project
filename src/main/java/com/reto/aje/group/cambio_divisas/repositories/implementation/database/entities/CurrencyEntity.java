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
@Table("CURRENCY")
public class CurrencyEntity {

    @Id
    @Column("CU_ID")
    private Long cuId;

    @Column("CU_UUID")
    private String cuUuid;

    @Column("CU_CODE")
    private String cuCode;

    @Column("CU_DESC")
    private String cuDesc;

    @CreatedDate
    @Column("CU_CREATED_AT")
    private LocalDateTime cuCreatedAt;

    @LastModifiedDate
    @Column("CU_UPDATED_AT")
    private LocalDateTime cuUpdatedAt;
}