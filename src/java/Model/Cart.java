/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoc
 */
public class Cart {

    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getItemById(int id) {
        for (Item item : items) {
            if (item.getProduct().getId_product() == id) {
                return item;
            }
        }
        return null;
    }

    public int getTotalMoney() {
        int t = 0;
        for (Item item : items) {
            t += item.getQuantity() * item.getPrice();
        }
        return t;
    }

}
