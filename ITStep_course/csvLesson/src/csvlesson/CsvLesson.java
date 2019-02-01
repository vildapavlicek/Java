/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvlesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Student
 */
public class CsvLesson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        String[] text = null;
        
        int[][] pole = new int[10][10]; // tak si vytvorime pole 10x10 integer

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                pole[i][j] = i * j;
            }

        }

        String radek = "";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("soubor.txt"))) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    radek+=Integer.toString(pole[i][j]) + ";";
                 
                }
                bw.write(radek);
                bw.newLine();
                radek = "";
            }
        } catch (Exception e) {
            System.err.println("Do souboru se nepovedlo zapsat.");
        }
        
        
        // udelat nacteni souboru
        
        try (BufferedReader br = new BufferedReader(new FileReader("soubor.txt")))
{
        String s;
        while ((s = br.readLine()) != null)
        {
                
            text = s.split(";"); // splituju do pole > odstranuji ";"
            for (String text1 : text) {
                System.out.print(text1 + " "); // tisknu pole > dostavam cele hodnoty bez ; pro prehlednost oddeluji " "
            }
            System.out.print("\n"); // tisknu \n pomoci prazdneho stringu
           // System.out.println(s);
        }
}
catch (Exception e)
{
        System.err.println("Chyba při četení ze souboru.");
}

    }

}
