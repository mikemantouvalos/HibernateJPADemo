/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergon.hibernatedemo.dao;

import com.emergon.hibernatedemo.entities.Sale;
import java.util.List;

/**
 *
 * @author anastasios
 */
public class SaleDao extends HibernateUtil<Sale>{
    
    public List<Sale> findAll(){
        return super.findAll("from Sale");
    }
    
    public Sale find(int id){
        return super.find(Sale.class, id);
    }
    
    public Sale save(Sale c){
        return super.save(c);
    }
    
    public Sale update(Sale c){
        return super.update(c);
    }
    
    public void delete(int id){
        super.delete(Sale.class, id);
    }
}
