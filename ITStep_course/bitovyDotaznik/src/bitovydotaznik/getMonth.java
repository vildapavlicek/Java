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
public class getMonth {

    public static byte inputMonth() throws Exception {

        int mesic;

        System.out.println("Zadejte měsíc narození číslicemi 1 až 12.");

        Scanner sc = new Scanner(System.in);
        mesic = sc.nextInt();

        System.out.println("Zadali jste: " + mesic);

        if (mesic > 12 | mesic < 1) {

            throw new Exception();

        } else {

            switch (mesic) {
                case 1:
                    return (byte) 0x01;
                case 2:
                    return (byte) 0x02;
                case 3:
                    return (byte) 0x03;
                case 4:
                    return (byte) 0x04;
                case 5:
                    return (byte) 0x05;
                case 6:
                    return (byte) 0x06;
                case 7:
                    return (byte) 0x07;
                case 8:
                    return (byte) 0x08;
                case 9:
                    return (byte) 0x09;
                case 10:
                    return (byte) 0xA;
                case 11:
                    return (byte) 0xB;
                case 12:
                    return (byte) 0xC;
            }

        }
        return 0;

        
    }

}
