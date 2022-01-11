package com.company.banktest.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "CREDIT_OFFER", indexes = {
        @Index(name = "IDX_CREDITOFFER_CLIENT_ID", columnList = "CLIENT_ID"),
        @Index(name = "IDX_CREDITOFFER_CREDIT_ID", columnList = "CREDIT_ID"),
        @Index(name = "IDX_CREDITOFFER", columnList = "SCHEDULE_PAYMENT_ID")
})
@Entity
public class CreditOffer {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "CLIENT_ID", nullable = false)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Client client;

    @JoinColumn(name = "CREDIT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Credit credit;

    @Column(name = "SUM_CREDIT")
    private Double sumCredit;

    @JoinColumn(name = "SCHEDULE_PAYMENT_ID", nullable = false)
    @Composition
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private SchedulePayment schedulePayment;

    public SchedulePayment getSchedulePayment() {
        return schedulePayment;
    }

    public void setSchedulePayment(SchedulePayment schedulePayment) {
        this.schedulePayment = schedulePayment;
    }

    public Double getSumCredit() {
        return sumCredit;
    }

    public void setSumCredit(Double sumCredit) {
        this.sumCredit = sumCredit;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}