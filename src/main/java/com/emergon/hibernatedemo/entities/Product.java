package com.emergon.hibernatedemo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    
    @Id
    @Column(name = "pcode")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pcode;
    @Column(name = "pdescr")
    private String description;
    @Column(name = "pprice")
    private double price;
    @OneToMany(mappedBy = "product")
    private List<Sale> sales;
    
    public Product() {
    }

    public Product(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Sale> getSales() {
        return sales;
    }

    @Override
    public String toString() {
        return "Product{" + "pcode=" + pcode + ", description=" + description + ", price=" + price + '}';
    }
    
    
}
