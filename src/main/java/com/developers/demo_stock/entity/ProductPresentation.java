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
@Entity(name = "product_presentation")
public class ProductPresentation {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    @NotEmpty
    @Size(max = 50, message = "Tamaño no permitido")
    private String presentation_code;

    @Column
    @NotEmpty
    @Size(max = 255, message = "Tamaño no permitido")
    private String presentation_name;

    @Column
    @Size(max = 50, message = "Tamaño no permitido")
    private String alternative_code;

    @Temporal(TemporalType.DATE)
    @Column
    private Date creation_date;

    @Column
    private boolean enabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_family_id")
    //@NotNull
    private ProductFamily product_family;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_brand_id")
    //@NotNull
    private ProductBrand product_brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_size_id")
    //@NotNull
    private ProductSize product_size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_color_id")
    //@NotNull
    private ProductColor product_color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    //@NotNull
    private Product product;

    @Column
    @Size(max = 50, message = "Tamaño no permitido")
    private String barcode;
    
    @Column
    private double cost;
    
    @Column
    private double weight;
   


    @PrePersist
    public void prePersist() {
        creation_date = new Date();
    }

    public ProductPresentation() {

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

    public String getPresentation_code() {
        return presentation_code;
    }

    public void setPresentation_code(String presentation_code) {
        this.presentation_code = presentation_code;
    }

    public String getPresentation_name() {
        return presentation_name;
    }

    public void setPresentation_name(String presentation_name) {
        this.presentation_name = presentation_name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ProductFamily getProductFamily() {
        return product_family;
    }

    public void setProductFamily(ProductFamily product_family) {
        this.product_family = product_family;
    }

    public ProductBrand getProductBrand() {
        return product_brand;
    }

    public void setProductBrand(ProductBrand product_brand) {
        this.product_brand = product_brand;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public ProductSize getProductSize() {
        return product_size;
    }

    public void setProductSize(ProductSize product_size) {
        this.product_size = product_size;
    }

    public ProductColor getProductColor() {
        return product_color;
    }

    public void setProductColor(ProductColor product_color) {
        this.product_color = product_color;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((presentation_code == null) ? 0 : presentation_code.hashCode());
        result = prime * result + ((product_family == null) ? 0 : product_family.hashCode());
        result = prime * result + ((product_brand == null) ? 0 : product_brand.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + ((product_size == null) ? 0 : product_size.hashCode());
        result = prime * result + ((creation_date == null) ? 0 : creation_date.hashCode());
        result = prime * result + ((presentation_name == null) ? 0 : presentation_name.hashCode());
        result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
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
        ProductPresentation other = (ProductPresentation) obj;
        if (presentation_code == null) {
            if (other.presentation_code != null) {
                return false;
            }
        } else if (!presentation_code.equals(other.presentation_code)) {
            return false;
        }
        if (product_family == null) {
            if (other.product_family != null) {
                return false;
            }
        } else if (!product_family.equals(other.product_family)) {
            return false;
        }
        
        if (product_brand == null) {
            if (other.product_brand != null) {
                return false;
            }
        } else if (!product_brand.equals(other.product_brand)) {
            return false;
        }
        
        if (product_size == null) {
            if (other.product_size != null) {
                return false;
            }
        } else if (!product_size.equals(other.product_size)) {
            return false;
        }
        
        if (product_color == null) {
            if (other.product_color != null) {
                return false;
            }
        } else if (!product_color.equals(other.product_color)) {
            return false;
        }
        
        if (product == null) {
            if (other.product != null) {
                return false;
            }
        } else if (!product.equals(other.product)) {
            return false;
        }
        
        if (creation_date == null) {
            if (other.creation_date != null) {
                return false;
            }
        } else if (!creation_date.equals(other.creation_date)) {
            return false;
        }
        
        if (presentation_name == null) {
            if (other.presentation_name != null) {
                return false;
            }
        } else if (!presentation_name.equals(other.presentation_name)) {
            return false;
        }
        
        if (barcode == null) {
            if (other.barcode != null) {
                return false;
            }
        } else if (!barcode.equals(other.barcode)) {
            return false;
        }
        
        if (alternative_code == null) {
            if (other.alternative_code != null) {
                return false;
            }
        } else if (!alternative_code.equals(other.alternative_code)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        return true;
    }

}
