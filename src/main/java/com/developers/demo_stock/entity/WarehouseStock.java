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
@Entity(name = "warehouse_stock")
public class WarehouseStock {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column
    private Date creation_date;

    @Temporal(TemporalType.DATE)
    @Column
    private Date batch_initial_date;

    @Temporal(TemporalType.DATE)
    @Column
    private Date batch_expiration_date;

    @Column
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_presentation_id")
    @NotNull
    private ProductPresentation product_presentation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    @NotNull
    private Warehouse warehouse;

    @Column
    @Size(max = 50, message = "Tamaño no permitido")
    private String product_batch_code;

    @Column
    @Size(max = 50, message = "Tamaño no permitido")
    private String product_batch_name;

    @Column
    private double existence;


    @PrePersist
    public void prePersist() {
        creation_date = new Date();
    }

    public WarehouseStock() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getBatch_initial_date() {
        return batch_initial_date;
    }

    public void setBatch_initial_date(Date batch_initial_date) {
        this.batch_initial_date = batch_initial_date;
    }

    public Date getBatch_expiration_date() {
        return batch_expiration_date;
    }

    public void setBatch_expiration_date(Date batch_expiration_date) {
        this.batch_expiration_date = batch_expiration_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ProductPresentation getProduct_presentation() {
        return product_presentation;
    }

    public void setProduct_presentation(ProductPresentation product_presentation) {
        this.product_presentation = product_presentation;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getProduct_batch_code() {
        return product_batch_code;
    }

    public void setProduct_batch_code(String product_batch_code) {
        this.product_batch_code = product_batch_code;
    }

    public String getProduct_batch_name() {
        return product_batch_name;
    }

    public void setProduct_batch_name(String product_batch_name) {
        this.product_batch_name = product_batch_name;
    }

    public double getExistence() {
        return existence;
    }

    public void setExistence(double existence) {
        this.existence = existence;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.creation_date);
        hash = 47 * hash + Objects.hashCode(this.batch_initial_date);
        hash = 47 * hash + Objects.hashCode(this.batch_expiration_date);
        hash = 47 * hash + (this.active ? 1 : 0);
        hash = 47 * hash + Objects.hashCode(this.product_presentation);
        hash = 47 * hash + Objects.hashCode(this.warehouse);
        hash = 47 * hash + Objects.hashCode(this.product_batch_code);
        hash = 47 * hash + Objects.hashCode(this.product_batch_name);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.existence) ^ (Double.doubleToLongBits(this.existence) >>> 32));
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
        final WarehouseStock other = (WarehouseStock) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (Double.doubleToLongBits(this.existence) != Double.doubleToLongBits(other.existence)) {
            return false;
        }
        if (!Objects.equals(this.product_batch_code, other.product_batch_code)) {
            return false;
        }
        if (!Objects.equals(this.product_batch_name, other.product_batch_name)) {
            return false;
        }
        if (!Objects.equals(this.creation_date, other.creation_date)) {
            return false;
        }
        if (!Objects.equals(this.batch_initial_date, other.batch_initial_date)) {
            return false;
        }
        if (!Objects.equals(this.batch_expiration_date, other.batch_expiration_date)) {
            return false;
        }
        if (!Objects.equals(this.product_presentation, other.product_presentation)) {
            return false;
        }
        if (!Objects.equals(this.warehouse, other.warehouse)) {
            return false;
        }
        return true;
    }

}
