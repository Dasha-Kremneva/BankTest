package com.company.banktest.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "SCHEDULE_PAYMENT")
@Entity
public class SchedulePayment {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "DATE_", nullable = false)
    private LocalDateTime date;

    @Column(name = "SUM_PAY", nullable = false)
    private Double sumPay;

    @Column(name = "SUM_BODY", nullable = false)
    private Double sumBody;

    @Column(name = "SUM_PERCENT", nullable = false)
    private Double sumPercent;

    public Double getSumPercent() {
        return sumPercent;
    }

    public void setSumPercent(Double sumPercent) {
        this.sumPercent = sumPercent;
    }

    public Double getSumBody() {
        return sumBody;
    }

    public void setSumBody(Double sumBody) {
        this.sumBody = sumBody;
    }

    public Double getSumPay() {
        return sumPay;
    }

    public void setSumPay(Double sumPay) {
        this.sumPay = sumPay;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}