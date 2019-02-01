/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesim;

import storesim.Items.Item;
import java.util.HashMap;
import java.util.Map;

import storesim.Items.Rose;

/**
 * Warehouse should contain all of the items.
 *
 * @author vilda
 */
public class Warehouse {

    public static HashMap<Item, Integer> warehouse;

    /**
     *
     */
    public Warehouse() {
        Warehouse.warehouse = new HashMap<>();
        Warehouse.warehouse.put(new Rose(), 1000000);

    }

    public void printMap() {
        for (Map.Entry<Item, Integer> entry : Warehouse.warehouse.entrySet()) {
            System.out.println(entry.getKey() + " / number of items in warehouse: " + entry.getValue());
        }
    }

}
