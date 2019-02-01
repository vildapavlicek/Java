/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceasarovasifra;

/**
 *
 * @author Student
 */
public class CeasarovaSifra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int i = 0;
        int j = 0;
        String text = "zz"; //FDVMVRXSHQLCH
        int delka = text.length();
        int posun = 1;
        char pismeno;
        int asciiPismeno;
        int rozdil;
        String code = "";
        boolean koder = true;

        /*  pismeno = text.charAt(0);
        asciiPismeno = (int) pismeno;
        
        asciiPismeno = (asciiPismeno + 1) - 25;
        pismeno = (char) asciiPismeno; */
        // A = 65, Z = 90
        text = text.toUpperCase();

        while (i < delka) {

            //když posun = textu
            if (posun == 25) {
                System.out.println(text);
                break;
            }
            //převod písmena na int
            asciiPismeno = (int) text.charAt(i);

            if (koder == true) {

                //ošetření přetečení ascii hodnoty A-Z
                if ((asciiPismeno + posun) > 90) {
                    asciiPismeno = (asciiPismeno + posun) - 26;

                } else {
                    asciiPismeno = asciiPismeno + posun;
                }

            } else {

                if ((asciiPismeno - posun) < 65) {
                    asciiPismeno = (asciiPismeno - posun) + 26;

                } //else if (asciiPismeno == 32) {asciiPismeno = 32;}
                else {
                    asciiPismeno = asciiPismeno - posun;
                }

            }

            pismeno = (char) asciiPismeno;
            code = code + pismeno;
            i++;

        }

        System.out.println(code);

    }

}
