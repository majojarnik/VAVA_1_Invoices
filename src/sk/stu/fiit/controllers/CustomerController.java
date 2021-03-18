/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.controllers;

import sk.stu.fiit.data.Data;
import sk.stu.fiit.exceptions.BlankFields;
import sk.stu.fiit.model.Customer;

/**
 *
 * @author jarni
 */
public class CustomerController {
    
    public void addCustomer(String name, String city, String street, String psc) throws BlankFields{
        
        if ("".equals(name) || "".equals(city) || "".equals(street) || "".equals(psc)){
            throw new BlankFields();
        }
        
        Customer cus = new Customer(name, street, city, psc);
        Data.getAllCustomers().add(cus);
    }
    
    public void editCustomer(Customer cus, String name, String city, String street, String psc) throws BlankFields{
        
        if ("".equals(name) || "".equals(city) || "".equals(street) || "".equals(psc)){
            throw new BlankFields();
        }
        
        cus.setName(name);
        cus.setCity(city);
        cus.setPsc(psc);
        cus.setStreet(street);
        
        //Data.getAllCustomers().add(cus);
    }
    
    public CustomerController(){
    }
    
    
}
