package com.example.ShoppingCartApplication.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Apparel extends Product {

    String type;
    String brand;
    String design;

    public Apparel() {
    }

    public Apparel( String productName, float productPrice, String type, String brand, String design) {
        super( productName, productPrice);
        this.type = type;
        this.brand = brand;
        this.design = design;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }
}
