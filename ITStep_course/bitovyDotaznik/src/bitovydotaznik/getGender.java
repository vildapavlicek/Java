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
public class getGender {

    public static byte inputGender() throws Exception {

        int pohlavi;
        System.out.println("Zadejte pohlaví. Pro muže '0' a pro ženu '1'");

        Scanner sc = new Scanner(System.in);
        pohlavi = sc.nextInt();

        System.out.println("Zadali jste: " + pohlavi);

        if (pohlavi > 1) {
            throw new Exception();
        } else if (pohlavi == 0) {
            return (byte) 0x00;
        } else {
            return (byte) 0x01;
        }

    }
}
