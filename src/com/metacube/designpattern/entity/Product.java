package com.metacube.designpattern.entity;

/**
 * @author Gaurav
 * POJO class
 */
public class Product {
    private String code;
    private String name;
    private String price;

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
	
    public Product(){

    }

    public String getCode() {
            return code;
    }

    public String getName() {
            return name;
    }

    public String getPrice() {
            return price;
    }
}
