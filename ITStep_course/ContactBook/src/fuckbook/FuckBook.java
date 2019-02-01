/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuckbook;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Vilda
 */
public class FuckBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        // Courtesan(String name, String asl, int height, int boobs, int weight, int rating) //
        Courtesan mirka;
        Courtesan ludek;
        Courtesan helena;
        Courtesan a = null;

        CourtesanList cl = new CourtesanList();

        System.out.println("Nacitam soubor..");
        cl = SerializeDeserialize.deserializace();

        if (cl == null) {

            /* mirka = new Courtesan("Mirka", "28/F/Praha 4", 165, 2, 59, 7);
            ludek = new Courtesan("Ludek", "16/M/GayBar", 180, 0, 80, 2);
            helena = new Courtesan("Helena", "40/F/Brno", 175, 5, 50, 10);

            cl.data.add(ludek);
            cl.data.add(mirka);
            cl.data.add(helena);

            //System.out.println(cl);
            System.out.println("Ukládám do souboru.");
            SerializeDeserialize.serializace(cl); */
            System.out.println("Soubor je prazndy. Chcete zadat novy zaznam? Y/N");


            cl.data.add(a);

        } else {
            System.out.println("Soubor obsahuje data: ");
            System.out.println(cl);
        }

        /*

        mirka = new Courtesan("Mirka", "28/F/Praha 4", 165, 2, 59, 7);
        ludek = new Courtesan("Ludek", "16/M/GayBar", 180, 0, 80, 2);
        helena = new Courtesan("Helena", "40/F/Brno", 175, 5, 50, 10);

        cl.data.add(ludek);
        cl.data.add(mirka);
        cl.data.add(helena);

        
        
        System.out.println(cl);
        System.out.println("Serializace..");
        SerializeDeserialize.serializace(cl); 
       
        System.out.println("Deserializace");
        clTwo = SerializeDeserialize.deserializace();
        System.out.println(clTwo);
         */
    }

}
