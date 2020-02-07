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

@Entity(name = "users")
public class Users {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    @NotEmpty
    @Size(max = 50, message = "Tamaño no permitido")
    private String code;

    @Column
    @NotEmpty
    @Size(max = 50, message = "Tamaño no permitido")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @NotNull
    private Person person;

    @Temporal(TemporalType.DATE)
    @Column
    private Date creation_date;

    @Column
    private boolean active;

    @Temporal(TemporalType.DATE)
    @Column
    private Date disabled_date;

    @Column
    @NotEmpty
    @Size(max = 50, message = "Tamaño no permitido")
    private String password;

    @Column
    @NotEmpty
    @Size(max = 50, message = "Tamaño no permitido")
    private String fullname;

    @PrePersist
    public void prePersist() {
        creation_date = new Date();
    }

    public Users() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDisabled_date() {
        return disabled_date;
    }

    public void setDisabled_date(Date disabled_date) {
        this.disabled_date = disabled_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.code);
        hash = 53 * hash + Objects.hashCode(this.username);
        hash = 53 * hash + Objects.hashCode(this.person);
        hash = 53 * hash + Objects.hashCode(this.creation_date);
        hash = 53 * hash + (this.active ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.disabled_date);
        hash = 53 * hash + Objects.hashCode(this.password);
        hash = 53 * hash + Objects.hashCode(this.fullname);
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
        final Users other = (Users) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.fullname, other.fullname)) {
            return false;
        }
        if (!Objects.equals(this.person, other.person)) {
            return false;
        }
        if (!Objects.equals(this.creation_date, other.creation_date)) {
            return false;
        }
        if (!Objects.equals(this.disabled_date, other.disabled_date)) {
            return false;
        }
        return true;
    }
    

}
