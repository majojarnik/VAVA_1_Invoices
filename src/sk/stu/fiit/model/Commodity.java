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
public class Commodity {
    private String name;
    private String desc;
    private int price;
    private int number = 0;

    public Commodity(String name, String desc, int price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public Commodity(String name, String desc, int price, int number) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
    
}
