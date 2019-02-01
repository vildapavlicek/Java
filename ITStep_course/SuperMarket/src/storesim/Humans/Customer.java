/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesim.Humans;

import storesim.Items.Item;
import java.util.HashMap;
import java.util.Map;
import storesim.Shops.Shop;

/**
 * Extends Human, adds credit so can do shopping Adds sex
 *
 * @author vilda
 * @version 1.0
 */
public class Customer extends Human {

    /**
     * We're using credit instead of money
     */
    protected float credit;

    HashMap<Item, Integer> shoppingCart = new HashMap<>();

    HashMap<Item, Integer> shoppingList = new HashMap<>();

    public Customer(String name, String surname, int capacity, Sex sex, int hunger, int tired, float credit) {
        super(name, surname, capacity, sex, hunger, tired);
        this.credit = credit;
        shoppingCart = new HashMap<>();

    }

    public Customer(String name, String surname, int capacity, Sex sex, int hunger, int tired, float credit, HashMap shoppingList) {
        super(name, surname, capacity, sex, hunger, tired);
        this.credit = credit;
        shoppingCart = new HashMap<>();
        this.shoppingList = shoppingList;
    }

    /**
     * Returns the HashMap shoppingCart
     *
     * @return HashMap
     */
    public HashMap<Item, Integer> getShoppingCart() {
        return this.shoppingCart;
    }

    
    /**
     * Setter for credit
     *
     * @param credit
     */
    public void setCredit(float credit) {
        this.credit = credit;
    }

    /**
     * Returns runtime value of credit
     *
     * @return credit
     */
    public float getCredit() {
        return this.credit;
    }

    /**
     * Adds item to shoppingCart, requires item and count
     *
     * @param item
     * @param count
     */
    public void addToShoppingCart(Item item, int count) {
        this.shoppingCart.put(item, count);
    }

    /**
     * Removes item from shoppingCart based on key
     *
     * @param item
     */
    public void removeFromShoppingCart(Item item) {
        this.shoppingCart.remove(item);
    }

    /**
     * Returns boolean if inventory contains item
     *
     * @param Item
     * @return Boolean
     */
    public boolean hasItemInShoppingCart(Item item) {
        return this.shoppingCart.containsKey(item);
    }

    /**
     * Returns count of specified item in shoppingCart
     *
     * @param item
     * @return Integer
     */
    public Integer getItemCountFromShoppingCart(Item item) {
        return this.shoppingCart.get(item);
    }

    /**
     *
     * Method that gets item from shop and adds it to the customer's
     * shoppingCart
     *
     * Checks if item is already in shoppingCart, if true adds only count
     *
     * @param shop
     * @param item
     * @param count
     */
    public void getItemFromShop(Shop shop, Item item, int count) {
        if (!this.hasItemInShoppingCart(item)) {
            this.addToShoppingCart(item, count);
        } else {
            this.shoppingCart.replace(item, this.getCountOfItemInInventory(item) + count);
        }
    }

    @Override
    public String toString() {
        return "Jmeno: " + this.name + "\n" + "Prijmeni: " + this.surname + "\n" + "Pohlavi je: " + this.sex
                + "\n" + "Kapacita: " + this.capacity + "\n" + "Hlad: " + this.hunger + "\n" + "Unava: " + this.tired
                + "\n" + "Kredity: " + this.credit + "\n";
    }
}
