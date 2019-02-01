/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesim.Shops;

import storesim.Shops.Shop;
import storesim.Items.Item;
import java.util.Map;

/**
 *
 * @author Student
 */
public class Grocery extends Shop {

    public Grocery(Map<Item, Integer> products) {
        super(products);
    }
    
}
