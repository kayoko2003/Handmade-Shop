/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ngoc
 */
public class Product {
    private int id_product;
    private String name_product;
    private int price;
    private String describe;
    private String image;
    private Date import_date;
    private int num_purchases;
    private int quantity;
    private boolean isShow;
    private Category category;

    public Product() {
    }

    public Product(int id_product, String name_product, int price, String describe, String image, Date import_date, int num_purchases, int quantity, boolean isShow, Category category) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.price = price;
        this.describe = describe;
        this.image = image;
        this.import_date = import_date;
        this.num_purchases = num_purchases;
        this.quantity = quantity;
        this.isShow = isShow;
        this.category = category;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getImport_date() {
        return import_date;
    }

    public void setImport_date(Date import_date) {
        this.import_date = import_date;
    }

    public int getNum_purchases() {
        return num_purchases;
    }

    public void setNum_purchases(int num_purchases) {
        this.num_purchases = num_purchases;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isIsShow() {
        return isShow;
    }

    public void setIsShow(boolean isShow) {
        this.isShow = isShow;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "id_product=" + id_product + ", name_product=" + name_product + ", price=" + price + ", describe=" + describe + ", image=" + image + ", import_date=" + import_date + ", num_purchases=" + num_purchases + ", quantity=" + quantity + ", isShow=" + isShow + ", category=" + category + '}';
    }

    
}
