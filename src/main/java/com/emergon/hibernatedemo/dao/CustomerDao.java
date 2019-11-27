/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergon.hibernatedemo.dao;

import com.emergon.hibernatedemo.entities.Customer;
import com.emergon.hibernatedemo.entities.Sale;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author anastasios
 */
public class CustomerDao extends HibernateUtil<Customer>{
    
    public List<Customer> findAll(){
        return super.findAll("from Customer");
    }
    
    public Customer find(int id){
        return super.find(Customer.class, id);
    }
    public Customer getCustomerWithoutClosingEm(int id){
        EntityManager em = getEntityManager();
        Customer t = em.find(Customer.class, id);
        return t;
    }
    
    public Customer save(Customer c){
        return super.save(c);
    }
    
    public Customer update(Customer c){
        return super.update(c);
    }
    
    public void delete(int id){
        super.delete(Customer.class, id);
    }
    
    public List<Sale> getSalesByCustomer(Customer c){
        EntityManager em = getEntityManager();
        //Customers c = em.find(Customer.class, id);
        //The list is a new ArrayList because when the em.closes then the Customer c becomes detached. 
        List<Sale> sales = c.getSales();
        em.close();
        return sales;
    }
    
    public Customer getEagerCustomerById(int id){
        EntityManager em = getEntityManager();
        Customer c = em.find(Customer.class, id);
        c.getSales().size();//This line is used to call the List of sales. The size() is NEEDED.
        em.close();
        return c;
    }
    public Customer getEagerCustomerByIdQuery(int id){
        EntityManager em = getEntityManager();
        TypedQuery<Customer> q = em.createQuery("SELECT c FROM Customers c "
                + "JOIN FETCH c.sales WHERE c.ccode =:id", Customer.class);
        q.setParameter("id", id);
        Customer c = q.getSingleResult();
        em.close();
        return c;
    }
}
