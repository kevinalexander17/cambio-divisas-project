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
@Table("TRANSACTION_LOG")
public class TransactionLogEntity {

    @Id
    @Column("TXN_ID")
    private Long txnId;

    @Column("TXN_UUID")
    private String txnUuid;

    @Column("TXN_TYPE")
    private String txnType;

    @Column("TXN_AMT_ORIG")
    private Double txnAmtOrig;

    @Column("TXN_CURR_ORIG")
    private String txnCurrOrig;

    @Column("TXN_AMT_TGT")
    private Double txnAmtTgt;

    @Column("TXN_CURR_TGT")
    private String txnCurrTgt;

    @CreatedDate
    @Column("TXN_CREATED_AT")
    private LocalDateTime txnCreatedAt;

    @LastModifiedDate
    @Column("TXN_UPDATED_AT")
    private LocalDateTime txnUpdatedAt;
}
