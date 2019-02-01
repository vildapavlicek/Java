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
public class getMaritalStatus {
    public static byte inputMartialStatus() {
        Scanner sc = new Scanner(System.in);
        
        String getMartialStatus = "";
        int count = 0;
        int i = 0;
        byte setMartialStatus=0;
        System.out.println("Zadejte rodinný stav.\n\nPro \"svobodný\" - S.\nPro \"v manželském svazku\" - M.");
        while (true) {
            if (i == 0) {
                
                getMartialStatus = sc.nextLine();
                
            }
            if (!getMartialStatus.matches("[SM]")) {
                System.out.println("Nezadali jste správnou volbu zadejte pouze S nebo M");
                
                continue;
            }

            i++;
            if (i == getMartialStatus.length()) {

                break;
            }
        }
        if(getMartialStatus.charAt(0)=='S'){setMartialStatus=0;}
        else{setMartialStatus=0x40;}

       
        return setMartialStatus;
    }
}
