/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storesim;

import java.util.ArrayList;
import storesim.Items;
import storesim.Items.Meat;

/**
 *
 * @author Student
 */
public class Supermarket {
    ArrayList<Human>people; //maybe uselless, its already in blackboard memory of BT
    ArrayList<Shop>stores; 
    Warehouse warehouse;
    Cashier cashier;
    
    public Supermarket(ArrayList<Human>people,ArrayList<Shop>stores,Warehouse warehouse,Cashier cashier) {
        this.people=new ArrayList<Human>(people);
        this.stores=new ArrayList<Shop>(stores);
        this.warehouse=warehouse;
        this.cashier=cashier;
    }
    
    Item maso=new Meat(); // vytvoří item pro obchodování a pro sklady a nákupní seznamy
        HashMap shoppingListNo1= new HashMap<>(); // nakupní seznam č.1
        shoppingListNo1.put(maso, 1);
        HashMap shoppingListNo2= new HashMap<>();// nakupní seznam č.2
        shoppingListNo2.put(maso, 1);
        HashMap shoppingListNo3= new HashMap<>();// nakupní seznam č.3
        shoppingListNo3.put(maso, 1);
        HashMap shoppingListNo4= new HashMap<>();// nakupní seznam č.4
        shoppingListNo4.put(maso, 1);
        HashMap shoppingListNo5= new HashMap<>();// nakupní seznam č.5
        shoppingListNo5.put(maso, 1);
        HashMap warehouse= new HashMap<>(); // skladiště ze kterého si obchody berou itemy na prodej
        warehouse.put(maso, 50);
        HashMap shopNo1Storehouse= new HashMap<>();//skladiště přímo na obchodě č.1
        shopNo1Storehouse.put(maso, 1);
        HashMap shopNo2Storehouse= new HashMap<>();//skladiště přímo na obchodě č.1
        shopNo2Storehouse.put(maso, 1);
        
        
        Human novak=new Customer ("No.1","Novak", 10, Human.Sex.MALE,10,10,200f,shoppingListNo1);//Zakazník č1
        Human polak=new Customer ("No.2","Polak", 10, Human.Sex.MALE,10,10,200f,shoppingListNo2);//Zakazník č2
        Human rolak=new Customer ("No.3","Rolak", 10, Human.Sex.MALE,10,10,200f,shoppingListNo3);//Zakazník č3
        Human dojak=new Customer ("No.4","Dojak", 10, Human.Sex.MALE,10,10,200f,shoppingListNo4);//Zakazník č4
        Human mrdak=new Customer ("No.5","Mrdak", 10, Human.Sex.MALE,10,10,200f,shoppingListNo5);//Zakazník č5
        ArrayList<Human>people=new ArrayList<Human>();// seznam zákazníků
        people.add(novak);
        people.add(polak);
        people.add(rolak);
        people.add(dojak);
        people.add(mrdak);
        
        Shop shopNo1=new Grocery(shopNo1Storehouse);//obchod č.1
        Shop shopNo2=new Grocery(shopNo2Storehouse);//obchod č.2
        ArrayList<Shop>stores=new ArrayList<Shop>();//seznam obchodů
        stores.add(shopNo2);
        stores.add(shopNo1);
        
        Cashier cashier= new Cashier();// nová instance pokladny pro supermarket
}
