package com.emergon.hibernatedemo.dao;

import com.emergon.hibernatedemo.entities.CustomerDetail;
import java.util.List;

public class CustomerDetailDao extends HibernateUtil<CustomerDetail>{
    
    public List<CustomerDetail> findAll(){
        return super.findAll("from CustomerDetail");
    }
    
    public CustomerDetail find(int id){
        return super.find(CustomerDetail.class, id);
    }
    
    public CustomerDetail save(CustomerDetail detail){
        return super.save(detail);
    }
    
    public CustomerDetail update(CustomerDetail detail){
        return super.update(detail);
    }
    
    public void delete(int id){
        super.delete(CustomerDetail.class, id);
    }
}
