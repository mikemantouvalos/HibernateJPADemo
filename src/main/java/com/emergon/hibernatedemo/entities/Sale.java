package com.emergon.hibernatedemo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sale implements Serializable{
    
    @Id
    @Column(name = "scode")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scode;
    @ManyToOne
    @JoinColumn(name = "pcode")
    private Product product;
    @Column(name = "sdate")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "ccode")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "smcode")
    private Salesman salesman;
    @Column(name = "quant")
    private int quantity;
    @Column(name = "cost")
    private double cost;

    public Sale() {
    }

    public Sale(Product product, LocalDate date, Customer customer, Salesman salesman, int quantity, double cost) {
        this.product = product;
        this.date = date;
        this.customer = customer;
        this.salesman = salesman;
        this.quantity = quantity;
        this.cost = cost;
    }

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Sale{" + "scode=" + scode + ", product=" + product + ", date=" + date + ", customer=" + customer + ", salesman=" + salesman + ", quantity=" + quantity + ", cost=" + cost + '}';
    }
    
}
