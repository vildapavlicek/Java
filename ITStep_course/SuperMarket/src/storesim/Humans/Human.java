/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesim.Humans;

import storesim.Items.Item;
import java.util.HashMap;
import java.util.Map;

/**
 * Basic object for creating customers. Should be used to extends and be
 * inherited by other objects. Implements basic methods and variables
 *
 * @author vilda
 * @version 1.0
 */
public class Human {

    public enum Sex {
        MALE, FEMALE, HERMAPHRODIT
    }

    /**
     * AL inventory should contain all items that belong to the owner
     */
    //ArrayList<Item> inventory;
    HashMap<Item, Integer> inventory = new HashMap<>();

    /**
     * Carrying capacity, determines how many person can carry, should be used
     * to limit how many items can be in inventory. Have to decide if it will be
     * decided based on weight or count of items
     */
    protected int capacity;
    /**
     * Hunger should be values of 0 - 10. If 10 the human is probably starving
     * Used to get human to eat something
     */
    protected int hunger;
    /**
     * Tired should show how much human is tired and be in values between 1 to
     * 10. If over 8, should leave the supermarket
     */
    protected int tired;

    /**
     * Determines human's sex. Values should be taken from enum
     */
    protected Sex sex;

    /**
     * Human's first name
     */
    String name;

    /**
     * Human's surname
     */
    String surname;

    public Human(String name, String surname, int capacity, Sex sex, int hunger, int tired) {
        this.inventory = new HashMap<>();
        this.sex = sex;
        this.capacity = capacity;
        this.hunger = hunger;
        this.tired = tired;
        this.name = name;
        this.surname = surname;
    }

    
        public HashMap<Item, Integer> getInventory() {
        return this.inventory;
    }

    
    /**
     * This method adds item to human's inventory
     *
     * @param item
     */
    public void addToInventory(Item item, int count) {
        this.inventory.put(item, count);
    }

    /**
     * This method removes item from human's inventory
     *
     * @param item
     */
    public void removeFromInventory(Item item) {
        this.inventory.remove(item);
    }

    /**
     * Returns boolean if inventory contains item
     *
     * @param Item
     * @return Boolean
     */
    public boolean hasItemInInventory(Item item) {
        return this.inventory.containsKey(item);
    }

    /**
     * Returns item count of specified item
     *
     * @param Item
     * @return Value(int)
     */
    public int getCountOfItemInInventory(Item item) {
        return this.inventory.get(item);
    }

    /**
     * Capacity setter
     *
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Return capacity runtime value
     *
     * @return capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Returns value of sex
     *
     * @return Sex
     */
    public Sex getSex() {
        return this.sex;
    }

}
