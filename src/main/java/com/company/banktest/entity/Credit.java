package com.company.banktest.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@JmixEntity
@Table(name = "CREDIT")
@Entity
public class Credit {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @PositiveOrZero
    @InstanceName
    @Column(name = "LIMIT_", nullable = false)
    private Double limit;

    @Positive
    @Column(name = "RATE", nullable = false)
    private Double rate;

    @JoinColumn(name = "BANK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @JoinColumn(name = "BANK_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)

   

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}