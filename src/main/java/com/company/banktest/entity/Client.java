package com.company.banktest.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.UUID;

@JmixEntity
@Table(name = "CLIENT")
@Entity
public class Client {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Email
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSPORT", nullable = false)
    private String passport;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "client", optional = false)
    private CreditOffer creditOffer;

    @JoinColumn(name = "BANK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CreditOffer getCreditOffer() {
        return creditOffer;
    }

    public void setCreditOffer(CreditOffer creditOffer) {
        this.creditOffer = creditOffer;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}