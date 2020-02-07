/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developers.demo_stock.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Panza
 */
@Entity(name = "person")
public class Person {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "civil_status_id")
    private CivilStatus civilStatus;

    @Column
    @NotEmpty
    @Size(max = 50, message = "Tamaño no permitido")
    private String name;

    @Column
    private boolean active;

    @Temporal(TemporalType.DATE)
    @Column
    private Date birthdate;

    @Temporal(TemporalType.DATE)
    @Column
    private Date creation_date;

    @Temporal(TemporalType.DATE)
    @Column
    private Date disabled_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_type_id")
    private PersonType personType;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getDisabled_date() {
        return disabled_date;
    }

    public void setDisabled_date(Date disabled_date) {
        this.disabled_date = disabled_date;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.civilStatus);
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + (this.active ? 1 : 0);
        hash = 31 * hash + Objects.hashCode(this.birthdate);
        hash = 31 * hash + Objects.hashCode(this.creation_date);
        hash = 31 * hash + Objects.hashCode(this.disabled_date);
        hash = 31 * hash + Objects.hashCode(this.personType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.civilStatus, other.civilStatus)) {
            return false;
        }
        if (!Objects.equals(this.birthdate, other.birthdate)) {
            return false;
        }
        if (!Objects.equals(this.creation_date, other.creation_date)) {
            return false;
        }
        if (!Objects.equals(this.disabled_date, other.disabled_date)) {
            return false;
        }
        if (!Objects.equals(this.personType, other.personType)) {
            return false;
        }
        return true;
    }

   

}
