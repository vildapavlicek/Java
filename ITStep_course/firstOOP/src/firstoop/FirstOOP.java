/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstoop;

/**
 *
 * @author Student
 */
public class FirstOOP {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
       
        //instance tridy contact list
        
        ContactList cl = new ContactList();
        
        Contact c = null;
        Contact d = null;
        
       try { 
       c = new Contact("Pepa","Patek","abcd","Nocni Hlidka 285");
       d = new Contact("Jana","Patkova","abcd","Nocni Hlidka 311");
        
       cl.data.add(c);
       cl.data.add(d);
       
       System.out.println(cl);
        } catch (InvalidPhoneNumberException e) {
        System.out.println(e.getMyErrorNumber() + " - Wrong phone number: " + e.getMessage());
        }
    }
    
}
