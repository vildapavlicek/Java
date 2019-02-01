package bitovydotaznik;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
public class fillArray {

    /**
     *
     * @return
     */
    public static boolean getFillArray() {
   
       boolean filler = true;
       String answer;
        String check = "Y";
       
       Scanner sc = new Scanner(System.in);
       System.out.println("Chcete zadat dalsi zaznam? Y/N");
       answer = sc.next();
       
        return (answer == null ? check == null : answer.equals(check));
           
       
       
   
   }
    
}
