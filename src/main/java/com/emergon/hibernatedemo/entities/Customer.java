/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergon.hibernatedemo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anastasios
 */
@Entity
@Table(name = "customer")//Optional(name is the same)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCcode", query = "SELECT c FROM Customer c WHERE c.ccode = :ccode")
    , @NamedQuery(name = "Customer.findByCname", query = "SELECT c FROM Customer c WHERE c.cname = :cname")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id//this is a primary key
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ccode")//optional
    private Integer ccode;
    @Basic(optional = false)
    @Column(name = "Cname")
    private String cname;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_deta_id")
    private CustomerDetail customerDetail;
    /*
    The mappedBy says: Look at the Sale class for a property named "customer"
    Then use information from the @JoinColumn annotation
    */
    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;
    
    public Customer() {
    }

    public Customer(Integer ccode) {
        this.ccode = ccode;
    }

    public Customer(String cname) {
        this.cname = cname;
    }

    public Customer(Integer ccode, String cname) {
        this.ccode = ccode;
        this.cname = cname;
    }

    public Integer getCcode() {
        return ccode;
    }

    public void setCcode(Integer ccode) {
        this.ccode = ccode;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public CustomerDetail getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
    }

    public List<Sale> getSales() {
        return sales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccode != null ? ccode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.ccode == null && other.ccode != null) || (this.ccode != null && !this.ccode.equals(other.ccode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer[ccode=" + ccode + ", cname="+cname+"]";
    }
    
}
