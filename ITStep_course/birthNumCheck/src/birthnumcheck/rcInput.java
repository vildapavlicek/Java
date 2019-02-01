/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birthnumcheck;

import java.util.Scanner;


/**
 *
 * @author Student
 */
public class rcInput {

    public static int[] input() {
        Scanner sc = new Scanner(System.in);
        int[] rc;
        String inputRC = "";
        int count = 0;
        int i = 0;
        while (true) {
            if (i == 0) {
                System.out.println("Zadejte své rodné číslo:");
                inputRC = sc.nextLine();
            }
            if ((!inputRC.matches("[0-9/]+")) || !(inputRC.length() <= 11)) {
                System.out.println("Nezadali jste správný formát rodného čísla");
                i = 0;
                count = 0;
                continue;
            }

            if (inputRC.charAt(i) == '/') {
                count++;
                if ((count > 1) || (count == 1 && inputRC.charAt(6) != '/')) {
                    System.out.println("Nezadali jste správný formát rodného čísla");
                    i = 0;
                    count = 0;
                    continue;
                }
            }
            i++;
            if (i == inputRC.length()) {

                break;
            }
        }
        inputRC = inputRC.replaceAll("[/]", "");
        inputRC = inputRC.trim();

        rc = new int[inputRC.length()];
        for (int j = 0; j < inputRC.length(); j++) {
            rc[j] = Integer.parseInt(String.valueOf(inputRC.charAt(j)));
            
        }
        return rc;
    }
}
