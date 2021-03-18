/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.model;

/**
 *
 * @author jarni
 */
public class Customer {
    private String name;
    private String street;
    private String city;
    private String psc;

    public Customer(String name, String street, String city, String psc) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.psc = psc;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }
    
    
    
}
