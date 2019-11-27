/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergon.hibernatedemo;

import com.emergon.hibernatedemo.dao.CustomerDetailDao;
import com.emergon.hibernatedemo.dao.HibernateUtil;
import com.emergon.hibernatedemo.dao.CustomerDao;
import com.emergon.hibernatedemo.dao.FamilyDao;
import com.emergon.hibernatedemo.dao.ProductDao;
import com.emergon.hibernatedemo.dao.SaleDao;
import com.emergon.hibernatedemo.dao.SalesmanDao;
import com.emergon.hibernatedemo.dao.StoreDao;
import com.emergon.hibernatedemo.entities.CustomerDetail;
import com.emergon.hibernatedemo.entities.Customer;
import com.emergon.hibernatedemo.entities.Family;
import com.emergon.hibernatedemo.entities.Product;
import com.emergon.hibernatedemo.entities.Sale;
import com.emergon.hibernatedemo.entities.Salesman;
import com.emergon.hibernatedemo.entities.Store;
import java.util.List;

/**
 *
 * @author anastasios
 */
public class MainClass extends HibernateUtil<Customer> {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        HibernateUtil.closeEntityManagerFactory();
        System.out.println("***Hibernate JPA app terminated***");

    }    

    public void createCustomerWithDetails(CustomerDao cdao) {
        //Creating new Customer with CustomerDetails
        Customer newCustomer = new Customer("Dimitriou");
        CustomerDetail customerDetail = new CustomerDetail("Panepistimiou 10");
        newCustomer.setCustomerDetail(customerDetail);
        newCustomer = cdao.save(newCustomer);
        System.out.println("The new Customer is==" + newCustomer + "||" + newCustomer.getCustomerDetail());
    }

    public static void printCustomerFromCustomerDetail() {
        CustomerDetailDao cddao = new CustomerDetailDao();
        CustomerDetail detail = cddao.find(1);
        Customer c = detail.getCustomer();
        System.out.println(detail + " ==>> " + c);
        //cddao.closeEntityManagerFactory();
    }

    public static void showSalesByCustomer(int ccode) {
        CustomerDao cdao = new CustomerDao();
        Customer c = cdao.getEagerCustomerByIdQuery(ccode);
        //Customers c = cdao.getCustomerWithoutClosingEm(ccode);

        if (c != null) {
            //List<Sale> sales = cdao.getSalesByCustomer(c);
            System.out.println("***Customer " + c.getCname() + " has participated in the following sales:");
            for (Sale s : c.getSales()) {
                System.out.printf("\tSaleID:%s, Product:%s, Date:%s, Quantity:%d, Cost:%.3f\n", s.getScode(), s.getProduct().getDescription(), s.getDate(), s.getQuantity(), s.getCost());
            }
        } else {
            System.out.println("Customer with ID:" + ccode + " does not exist");
        }
        //cdao.closeEntityManagerFactory();
    }

    public static void showSalesmanWithFamily(int scode) {
        SalesmanDao sdao = new SalesmanDao();
        Salesman s = sdao.getSalesmanWithFamily(scode);
        if (s.getFamily().isEmpty()) {
            System.out.println("\t" + s.getName() + " has no family members.");
        } else {
            System.out.println("\t"+ s.getName()+ " has the following family members:");
            for (Family member : s.getFamily()) {
                System.out.println("\t"+member);
            }

        }
        //sdao.closeEntityManagerFactory();
    }
    
    public static void showSalesmanWithStores(int scode){
        SalesmanDao sldao = new SalesmanDao();
        Salesman salesman = sldao.getStoresBySalesmanIdQuery(102);
        System.out.println(salesman);
        List<Store> stores = salesman.getStores();
        for(Store s:stores){
            System.out.println(s);
        }
        //sldao.closeEntityManagerFactory();
    }
    
    public static void showStoreWithSalesmen(int stid){
        StoreDao sdao = new StoreDao();
        Store s = sdao.getStoreWithSalesmen(1);
        System.out.println("Store:"+s.getStname()+" has the following salesmen");
        List<Salesman> list = (List)s.getSalesmanCollection();
        for (Salesman member : list) {
                System.out.println("\t"+member);
            }
        //sdao.closeEntityManagerFactory();
    }
    
    public static void addingStoreToSalesman(int scode){
        Store s = new Store("Sega", "2103658752");
        SalesmanDao sdao = new SalesmanDao();
        Salesman sm = sdao.getSalesmanWithStores(scode);
        sm.addStore(s);
        sm = sdao.update(sm);
        System.out.println(sm);
        //sdao.closeEntityManagerFactory();
    }
    
    public static void deleteStoreAndCheckJoinTable(int stid){
        StoreDao sdao = new StoreDao();
        sdao.delete(stid);
        //sdao.closeEntityManagerFactory();
    }
    public static void addNewSalesmanWithStore(){
        Salesman s = new Salesman("Ana", "lami", 0.12);
        Store st = new Store("SSS", "232");
        s.addStore(st);
        SalesmanDao sdao = new SalesmanDao();
        sdao.save(s);
        //sdao.closeEntityManagerFactory();
    }
    public static void deleteSalesman(int scode){
        SalesmanDao sdao = new SalesmanDao();
        sdao.delete(scode);
        //sdao.closeEntityManagerFactory();
    }
    
    public static void printAllCustomers() {
        CustomerDao cdao = new CustomerDao();
        for (Customer c : cdao.findAll()) {
            System.out.println(c + "||" + c.getCustomerDetail());
        }
        //cdao.closeEntityManagerFactory();
    }
    public static void printAllProducts() {
        ProductDao pdao = new ProductDao();
        for (Product p : pdao.findAll()) {
            System.out.println(p);
        }
        //pdao.closeEntityManagerFactory();
    }
    
    public static void printAllSalesmen() {
        SalesmanDao sdao = new SalesmanDao();
        for (Salesman s : sdao.findAll()) {
            System.out.println(s);
        }
        //sdao.closeEntityManagerFactory();
    }
    
    public static void printAllSales() {
        SaleDao sdao = new SaleDao();
        for (Sale s : sdao.findAll()) {
            System.out.println(s);
        }
        //sdao.closeEntityManagerFactory();
    }
    
    public static void printAllFamily() {
        FamilyDao sdao = new FamilyDao();
        for (Family s : sdao.findAll()) {
            System.out.println(s);
        }
        //sdao.closeEntityManagerFactory();
    }
    public static void printAllStores() {
        StoreDao sdao = new StoreDao();
        for (Store s : sdao.findAll()) {
            System.out.println(s);
        }
        //sdao.closeEntityManagerFactory();
    }
    
}
