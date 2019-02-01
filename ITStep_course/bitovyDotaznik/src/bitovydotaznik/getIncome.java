/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitovydotaznik;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class getIncome { 
    public static byte inputIncome() {
        Scanner sc = new Scanner(System.in);
        
        String getIncome = "";
        int count = 0;
        int i = 0;
        byte setIncome=0;
        System.out.println("Zadejte druh příjmu.\n\nPro dávky zadejte - D.\nPro příjem zadejte - P.");
        while (true) {
            if (i == 0) {
                
                getIncome = sc.nextLine();
                
            }
            if (!getIncome.matches("[DP]")) {
                System.out.println("Nezadali jste správnou volbu zadejte pouze P nebo D");
                
                continue;
            }

            i++;
            if (i == getIncome.length()) {

                break;
            }
        }
        if(getIncome.charAt(0)=='D'){setIncome=0;}
        else{setIncome=0x02;}

       
        return setIncome;
    }
    
}
