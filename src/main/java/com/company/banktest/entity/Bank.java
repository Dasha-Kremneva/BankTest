package com.company.banktest.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "BANK")
@Entity
public class Bank {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @OneToMany(mappedBy = "bank")
    @Composition
    private List<Credit> listCredits;

    @OneToMany(mappedBy = "bank")
    @Composition
    private List<Client> listClients;

    public void setListClients(List<Client> listClients) {
        this.listClients = listClients;
    }

    public List<Client> getListClients() {
        return listClients;
    }

    public void setListCredits(List<Credit> listCredits) {
        this.listCredits = listCredits;
    }

    public List<Credit> getListCredits() {
        return listCredits;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}