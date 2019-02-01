/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstoop;

import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class ContactList {
 
     ArrayList<Contact> data = new ArrayList<Contact>();
     
     @Override
     public String toString() {
     String dataElements="";
     for (Contact contact : data) {
     dataElements += contact.toString()+ " ";
     }
     return "ContactList{" + dataElements + "}";
         }
    
}
