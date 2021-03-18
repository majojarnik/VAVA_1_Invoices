/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.controllers;

import java.util.List;
import sk.stu.fiit.data.Data;
import sk.stu.fiit.exceptions.BlankFields;
import sk.stu.fiit.model.Commodity;
import sk.stu.fiit.model.Customer;
import sk.stu.fiit.model.Invoice;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author jarni
 */
public class InvoiceControler {
    
    public void addInvoice(int cus, List<Commodity> comms) throws BlankFields{
        
        if (cus == -1 || comms.isEmpty()){
            throw new BlankFields();
        }
        Customer customer = Data.getAllCustomers().get(cus);
        Customer cust = new Customer(customer.getName(), customer.getStreet(), customer.getCity(), customer.getPsc()); 
                
        LocalDate date = LocalDate.now(); 
        
        List<Commodity> clone = new ArrayList<Commodity>(comms);

        Invoice inv = new Invoice(date ,cust, clone);
        
        Data.getAllInvoices().add(inv);
    }

    public InvoiceControler() {
    }
    
}
