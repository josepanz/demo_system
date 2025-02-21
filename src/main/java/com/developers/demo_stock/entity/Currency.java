package com.developers.demo_stock.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Currency {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotEmpty
    @Size(max = 50, message = "Tamaño no permitido")
    private String code;

    @Column
    @NotEmpty
    @Size(max = 50, message = "Tamaño no permitido")
    private String description;

    @Column
    @NotEmpty
    @Size(max = 50, message = "Tamaño no permitido")
    private String symbol;

    @Column
    private boolean active;

    @Temporal(TemporalType.DATE)
    @Column
    private Date creation_date;

    public Currency() {

    }

    @PrePersist
    public void prePersist() {
        creation_date = new Date();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Currency [id=" + id + ", code=" + code + ", description=" + description + ", creation_date="
                + creation_date + ", symbol="+symbol+", active="+active+"]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((creation_date == null) ? 0 : creation_date.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
        result = prime * result + id;
        return result;
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
        Currency other = (Currency) obj;
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }
        if (creation_date == null) {
            if (other.creation_date != null) {
                return false;
            }
        } else if (!creation_date.equals(other.creation_date)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }

        if (symbol == null) {
            if (other.symbol != null) {
                return false;
            }
        } else if (!symbol.equals(other.symbol)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        return true;
    }

}
