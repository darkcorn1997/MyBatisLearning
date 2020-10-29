package com.how2java.pojo;

public class Product {
    private int id;
    private String name;
    private float price;
    private Category category;

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public float getPrice() {
        return this.price;
    }
    public Category getCategory() {return this.category;}
    public void setId(int id) {
        this.id=id;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setPrice(float price) {
        this.price=price;
    }
    public void setCategory(Category category) {this.category=category;}

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
