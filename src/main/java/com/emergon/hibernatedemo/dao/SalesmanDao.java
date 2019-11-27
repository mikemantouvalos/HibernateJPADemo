/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergon.hibernatedemo.dao;

import com.emergon.hibernatedemo.entities.Salesman;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author anastasios
 */
public class SalesmanDao extends HibernateUtil<Salesman>{
    
    public List<Salesman> findAll(){
        return super.findAll("from Salesman");
    }
    
    public Salesman find(int id){
        return super.find(Salesman.class, id);
    }
    
    public Salesman save(Salesman c){
        return super.save(c);
    }
    
    public Salesman update(Salesman c){
        return super.update(c);
    }
    
    public void delete(int id){
        super.delete(Salesman.class, id);
    }
    
    public Salesman getSalesmanWithFamily(int id){
        EntityManager em = getEntityManager();
        Salesman sm = em.find(Salesman.class, id);
        sm.getFamily().size();
        em.close();
        return sm;
    }
    
    public Salesman getSalesmanWithStores(int id){
        EntityManager em = getEntityManager();
        Salesman sm = em.find(Salesman.class, id);
        sm.getStores().size();
        em.close();
        return sm;
    }
    
    public Salesman getStoresBySalesmanIdQuery(int scode){
        EntityManager em = getEntityManager();
        TypedQuery<Salesman> q = em.createQuery("SELECT s FROM Salesman s JOIN FETCH s.stores WHERE s.scode =:scode ", Salesman.class);
        q.setParameter("scode", scode);
        Salesman sm = q.getSingleResult();
        em.close();
        return sm;
    }
    
}
