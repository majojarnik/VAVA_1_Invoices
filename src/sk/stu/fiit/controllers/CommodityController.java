/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.controllers;

import sk.stu.fiit.data.Data;
import sk.stu.fiit.exceptions.BlankFields;
import sk.stu.fiit.model.Commodity;


/**
 *
 * @author jarni
 */
public class CommodityController {
    
    public void addCommodity(String name, String desc, String price) throws BlankFields{
        
        if ("".equals(name) || "".equals(desc) || "".equals(price)){
            throw new BlankFields();
        }
        double cena;
        try {
            cena = Double.parseDouble(price) * 100;
            int priceNew = (int) cena;
            Commodity com = new Commodity(name, desc, priceNew);
            Data.getAllCommodities().add(com);
        }
        catch (NumberFormatException e){
            throw e;
        }
    }
 
    public void editCommodity(Commodity comm, String name, String desc, String price) throws BlankFields{
        if ("".equals(name) || "".equals(desc) || "".equals(price)){
            throw new BlankFields();
        }
        double cena;
        try {
            cena = Double.parseDouble(price) * 100;
            int priceNew = (int) cena;
            comm.setName(name);
            comm.setDesc(desc);
            comm.setPrice(priceNew);
            
        }
        catch (NumberFormatException e){
            throw e;
        }
    }
        
    public CommodityController(){
    }
    
    /*public void addCommodity(String name, String desc, String price, String number) throws BlankFields{
        
        if ("".equals(name) || "".equals(desc) || "".equals(price)){
            throw new BlankFields();
        }
        double cena;
        try {
            cena = Double.parseDouble(price) * 100;
            int priceNew = (int) cena;
            
            int num = Integer.parseInt(number);
            
            Commodity com = new Commodity(name, desc, priceNew, num);
            Data.getAllCommodities().add(com);
        }
        catch (NumberFormatException e){
            throw e;
        }
    }*/
    
}
