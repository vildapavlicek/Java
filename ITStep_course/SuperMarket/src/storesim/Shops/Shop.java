/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesim.Shops;

import java.util.HashMap;
import storesim.Items.Item;
import java.util.Map;
import storesim.Humans.Customer;

/**
 * Basic class to be inherited from if you want to build shop Contains category
 * that defines type of shop (ie restaurant, grocery etc.)
 *
 * @author vilda
 * @version 1.0
 */
public class Shop {

    public enum ShopCategory {

        GROCERY, DRUGSTORE, RESTAURANT, FASTFOOD, BOOKSHOP, GIFTSHOP, NEWSSTANDS, FLORIST
    }

    /**
     * category is int value that defines type of the shop (ie restaurant,
     * fastfood, grocery store)
     */
    protected int category;
    /**
     * list of products that shop offers, all products in this list should be
     * buyable
     */
    Map<Item, Integer> products = new HashMap<>();

    public Shop(Map<Item, Integer> products) {
        this.products = products;
    }

    /**
     * returns category runtime value
     *
     * @return category
     */
    public int getCategory() {
        return this.category;
    }

    /**
     * Method returns runtime count of item required on input
     * @param item
     * @return int - number of items
     */
    public int getItemCountOfProduct(Item item) {
        return this.products.get(item);
    }

    public void removeItemFromProducts(Item item, int count) {
        this.products.replace(item, this.getItemCountOfProduct(item) - count);
    }

    public boolean hasEnough(Item item, int count) {
        return this.getItemCountOfProduct(item) > count;
    }

}
