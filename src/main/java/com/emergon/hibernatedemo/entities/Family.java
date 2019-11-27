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
@Table(name = "family")
public class Family implements Serializable{
    @Id
    @Column(name = "fid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fname")
    private String name;
    @Column(name = "frelationship")
    private String relationship;
    @Column(name = "dob")
    private LocalDate dob;
    @ManyToOne
    @JoinColumn(name = "salesman", referencedColumnName = "scode")
    private Salesman salesman;
    public Family() {
    }

    public Family(String name, String relationship, LocalDate dob) {
        this.name = name;
        this.relationship = relationship;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    @Override
    public String toString() {
        return "Family{" + "id=" + id + ", name=" + name + ", relationship=" + relationship + ", dob=" + dob + '}';
    }
    
}
