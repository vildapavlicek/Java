/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesim;

import java.util.Map;
import storesim.Humans.Customer;
import storesim.Items.Item;

/**
 * Object that does transactions. Customer pays and moves items from
 * shoppingCart to inventory
 *
 * @author vilda
 */
public class Cashier {

    private float sumToPay;

    /**
     * Has customer on the input and calls method processPayment and clears
     * shoppingCart
     *
     * @param customer
     */
    public Cashier(){
        
    }
    public void doTransaction(Customer customer) {
        this.processPayment(this.sumPrice(customer), customer);
        customer.getShoppingCart().clear();

    }

    /**
     * Method do process payment, private, should be called only in method
     * doTransaction Takes value of sumToPay and subtracts it from customer's
     * credit
     *
     * @param sumToPay
     * @param customer
     */
    private void processPayment(float sumToPay, Customer customer) {

        customer.setCredit(customer.getCredit() - sumToPay);

    }

    /**
     * Counts the total sum of credits that customer has to pay for the items in
     * shoppingCart
     *
     * @param customer
     * @return sumToPay - float
     */
    private float sumPrice(Customer customer) {

        for (Map.Entry<Item, Integer> entry : customer.getShoppingCart().entrySet()) {

            switch (entry.getKey().getUnit()) {

                case GRAMS:
                    sumToPay += (entry.getValue() * entry.getKey().getPrice()) / 100;
                    customer.addToInventory(entry.getKey(), entry.getValue());
                    break;

                default:
                    sumToPay += (entry.getValue() * entry.getKey().getPrice());
                    customer.addToInventory(entry.getKey(), entry.getValue());
                    break;


                /* case KGS:
                    customer.addToInventory(entry.getKey(), entry.getValue());
                    return sumToPay;
                case PIECES:
                    sumToPay += entry.getValue() * entry.getKey().getPrice();
                    customer.addToInventory(entry.getKey(), entry.getValue());
                    return sumToPay;*/
            }

        }

        return sumToPay;
    }
}
