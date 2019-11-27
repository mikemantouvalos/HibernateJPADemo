package com.emergon.hibernatedemo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "salesman")
public class Salesman implements Serializable {

    @Id
    @Column(name = "scode")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scode;
    @Column(name = "sname")
    private String name;
    @Column(name = "scity")
    private String city;
    @Column(name = "scomm")
    private double commission;
    @OneToMany(mappedBy = "salesman")
    private List<Sale> sales;
    @OneToMany(mappedBy = "salesman",fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private List<Family> family;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "salesman_store", 
            joinColumns = {@JoinColumn(name = "scode", referencedColumnName = "scode")}, 
            inverseJoinColumns = {@JoinColumn(name = "stid", referencedColumnName = "stid")}
    )
    private List<Store> stores;
    
    public Salesman() {
    }

    public Salesman(String name, String city, double commission) {
        this.name = name;
        this.city = city;
        this.commission = commission;
    }

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public List<Family> getFamily() {
        return family;
    }

    public void setFamily(List<Family> family) {
        this.family = family;
    }

    public void addFamilyMember(Family member){
        if(family == null){
            family = new ArrayList();
        }
        family.add(member);
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
 
    public void addStore(Store store){
        if(stores == null){
            stores = new ArrayList();
        }
        stores.add(store);
    }
    @Override
    public String toString() {
        return "Salesman{" + "scode=" + scode + ", name=" + name + ", city=" + city + ", commission=" + commission + '}';
    }

}
