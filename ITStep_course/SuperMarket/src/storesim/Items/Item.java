/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesim.Items;

import java.util.ArrayList;
import storesim.Shops.Shop.ShopCategory;

/**
 * Basic item object extended by ItemWeighted and ItemCounted. Contains only
 * price parameter
 *
 * @author vilda
 * @version 1.0
 */
public abstract class Item {

    public enum Units {

        PIECES, KGS, GRAMS
    }

    /**
     * Price of the item
     */
    protected float price;

    /**
     * Name of the object (ie apple, orange, iPhone, Samsung)
     */
    protected String name;
    /**
     * Using enum Units, describes if object count is in KGs, Grams, or pieces
     */
    Units unit;
    /**
     * This is list of shops it is allowed to sell this.Item in
     */
    ArrayList<ShopCategory> shopCategory = new ArrayList<>();

     public Item() {

    }

    /**
     * Price setter
     *
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Price getter
     *
     * @return price
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * Returns type of units (KGs, Grams, pieces)
     *
     * @return Units
     */
    public Units getUnit() {
        return this.unit;
    }

    /**
     * Returns name of the object (apple, orange, iPhone)
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "; Price: " + this.price + "; Units: " + this.unit + "; ";
    }
}
