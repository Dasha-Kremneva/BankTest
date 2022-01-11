package com.company.banktest.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "BANK", indexes = {
        @Index(name = "IDX_BANK_LIST_CREDITS_ID", columnList = "LIST_CREDITS_ID"),
        @Index(name = "IDX_BANK_LIST_CLIENTS_ID", columnList = "LIST_CLIENTS_ID")
})
@Entity
public class Bank {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "LIST_CREDITS_ID")
    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    private Credit listCredits;

    @JoinColumn(name = "LIST_CLIENTS_ID")
    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    private Client listClients;

    public Client getListClients() {
        return listClients;
    }

    public void setListClients(Client listClients) {
        this.listClients = listClients;
    }

    public Credit getListCredits() {
        return listCredits;
    }

    public void setListCredits(Credit listCredits) {
        this.listCredits = listCredits;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}