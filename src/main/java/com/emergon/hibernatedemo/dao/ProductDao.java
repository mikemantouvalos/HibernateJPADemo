/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergon.hibernatedemo.dao;

import com.emergon.hibernatedemo.entities.Product;
import java.util.List;

/**
 *
 * @author anastasios
 */
public class ProductDao extends HibernateUtil<Product>{
    
    public List<Product> findAll(){
        return super.findAll("from Product");
    }
    
    public Product find(int id){
        return super.find(Product.class, id);
    }
    
    public Product save(Product c){
        return super.save(c);
    }
    
    public Product update(Product c){
        return super.update(c);
    }
    
    public void delete(int id){
        super.delete(Product.class, id);
    }
}
