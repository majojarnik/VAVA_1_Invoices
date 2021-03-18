/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.data;

import java.util.ArrayList;
import java.util.List;
import sk.stu.fiit.model.Commodity;
import sk.stu.fiit.model.Customer;
import sk.stu.fiit.model.Invoice;

/**
 *
 * @author jarni
 */
public class Data {
    
    private static List<Invoice> allInvoices = new ArrayList<>();
    private static List<Commodity> allCommodities = new ArrayList<>();
    private static List<Customer> allCustomers = new ArrayList<>();

    public static List<Invoice> getAllInvoices() {
        return allInvoices;
    }

    public static void setAllInvoices(List<Invoice> aAllInvoices) {
        allInvoices = aAllInvoices;
    }

    public static List<Commodity> getAllCommodities() {
        return allCommodities;
    }

    public static void setAllCommodities(List<Commodity> aAllCommodities) {
        allCommodities = aAllCommodities;
    }

    public static List<Customer> getAllCustomers() {
        return allCustomers;
    }

    public static void setAllCustomers(List<Customer> aAllCustomers) {
        allCustomers = aAllCustomers;
    }
    
}
