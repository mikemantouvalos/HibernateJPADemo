/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergon.hibernatedemo.dao;

import com.emergon.hibernatedemo.entities.Store;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author anastasios
 */
public class StoreDao extends HibernateUtil<Store>{
    
    public List<Store> findAll(){
        return super.findAll("from Store");
    }
    
    public Store find(int id){
        return super.find(Store.class, id);
    }
    
    public Store save(Store c){
        return super.save(c);
    }
    
    public Store update(Store c){
        return super.update(c);
    }
    
    public void delete(int id){
        super.delete(Store.class, id);
    }
    
    public Store getStoreWithSalesmen(int stid){
        EntityManager em = getEntityManager();
        TypedQuery<Store> q = em.createQuery("SELECT s FROM Store s JOIN FETCH s.salesmanCollection WHERE s.stid =:stid", Store.class);
        q.setParameter("stid", stid);
        Store store = q.getSingleResult();
        em.close();
        return store;
    }
}
