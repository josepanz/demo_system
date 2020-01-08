/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developers.demo_stock.entity;

import java.util.Date;
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
@Entity(name = "product")
public class Product {

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
    private String description;

    @Column
    @NotEmpty
    @Size(max = 50, message = "Tamaño no permitido")
    private String alternative_code;

    @Temporal(TemporalType.DATE)
    @Column
    private Date creation_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measured_unit_id")
    @NotNull
    private MeasuredUnit measured_unit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_vat_id")
    @NotNull
    private ProductVat product_vat;

    @PrePersist
    public void prePersist() {
        creation_date = new Date();
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlternative_code() {
        return alternative_code;
    }

    public void setAlternative_code(String alternative_code) {
        this.alternative_code = alternative_code;
    }

    public MeasuredUnit getMeasured_unit() {
        return measured_unit;
    }

    public void setMeasured_unit(MeasuredUnit measured_unit) {
        this.measured_unit = measured_unit;
    }

    public ProductVat getProduct_vat() {
        return product_vat;
    }

    public void setProduct_vat(ProductVat product_vat) {
        this.product_vat = product_vat;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((measured_unit == null) ? 0 : measured_unit.hashCode());
        result = prime * result + ((product_vat == null) ? 0 : product_vat.hashCode());
        result = prime * result + ((creation_date == null) ? 0 : creation_date.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((alternative_code == null) ? 0 : alternative_code.hashCode());
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
        Product other = (Product) obj;
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }
        if (measured_unit == null) {
            if (other.measured_unit != null) {
                return false;
            }
        } else if (!measured_unit.equals(other.measured_unit)) {
            return false;
        }
        if (product_vat == null) {
            if (other.product_vat != null) {
                return false;
            }
        } else if (!product_vat.equals(other.product_vat)) {
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
        if (id != other.id) {
            return false;
        }
        return true;
    }

}
