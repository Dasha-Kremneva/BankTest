package com.company.banktest.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CREDIT_OFFER", indexes = {
        @Index(name = "IDX_CREDIT_OFFER_CREDIT_ID", columnList = "CREDIT_ID")
})
@Entity
public class CreditOffer {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "CLIENT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @InstanceName
    private Client client;

    @JoinColumn(name = "CREDIT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Credit credit;

    @Positive
    @Column(name = "SUM_CREDIT")
    private Double sumCredit;

    @Column(name = "TERM_CREDIT", nullable = false)
    private Integer termCredit;

    @OneToMany(mappedBy = "creditOffer")
    @Composition
    private List<SchedulePayment> schedulePayment;

    public Integer getTermCredit() {
        return termCredit;
    }

    public void setTermCredit(Integer termCredit) {
        this.termCredit = termCredit;
    }

    public void setSchedulePayment(List<SchedulePayment> schedulePayment) {
        this.schedulePayment = schedulePayment;
    }

    public List<SchedulePayment> getSchedulePayment() {
        return schedulePayment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}