/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergon.hibernatedemo.dao;

import com.emergon.hibernatedemo.entities.Family;
import java.util.List;

/**
 *
 * @author anastasios
 */
public class FamilyDao extends HibernateUtil<Family>{
    public List<Family> findAll(){
        return super.findAll("from Family");
    }
    
    public Family find(int id){
        return super.find(Family.class, id);
    }
    
    public Family save(Family c){
        return super.save(c);
    }
    
    public Family update(Family c){
        return super.update(c);
    }
    
    public void delete(int id){
        super.delete(Family.class, id);
    }
    
}
