/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitovydotaznik;

import java.io.FileNotFoundException;



/**
 *
 * @author Student
 */
public class BitovyDotaznik {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        // 0 = pohlaví (0 = M, 1 = Z)
        // 1 = příjem (0 = davky, 1 = prijem)
        // 2 - 5 = mesic narozeni
        // 6 = stav ( 0 = svobodny, 1 = vdany/a)

        // udelat 1) naplneni, 2) vypis, 3) serializace - ulozeni do souboru
        byte[] suplik = new byte[5];
        byte dotaznik = 0;
        byte pohlavi = 0x00;
        byte mesic = 0;
        byte prijem = 0;
        byte stav = 0;
        boolean fill = true;
        int i = 0;
        byte[] suplikDva = null;

        while (fill) {

            try {
                pohlavi = getGender.inputGender();

            } catch (Exception e) {
                System.err.println("Zadaná špatná hodnota: " + pohlavi);
            }

            prijem = getIncome.inputIncome();

            try {
                mesic = getMonth.inputMonth();

            } catch (Exception e) {
                System.err.println("Zadaná špatná hodnota: " + mesic);
            }

            stav = getMaritalStatus.inputMartialStatus();

            dotaznik |= pohlavi;
            dotaznik |= prijem;
            dotaznik |= mesic << 2;
            dotaznik |= stav;

            System.out.println(Integer.toBinaryString(dotaznik));

            suplik[i] = dotaznik;
            i++;

            fill = fillArray.getFillArray();
        }
        
     
        System.out.println("Vypis pole:");
        for (int j = 0; j < suplik.length; j++) {
        
            System.out.println(Integer.toBinaryString(suplik[j]));
            
        }
        
        /*
        
        *********** ?? CO JE SERIALIZACE ?! **********
        serializace je to, ze vezmes objekt a ulozis ho do souboru
        
        ukladas objekt pole (jako cele pole, ne jeho hodnoty) do souboru
        
        */
        
        System.out.println("Serialiazace..");
           serializaceDeserializace.serializace(suplik);
           
           
           /* 
           
           *********** ?? CO JE DESERIALIZACE ?? **********
           když uložíš objekt do souboru tak vypadá jak sračka (neukládáš ani string ani int ani char, ale objekt jako objekt)
           deserializaci reknes, jaky objekt byl ulozeny a on z dat v souboru posklada objekt zpatky
           
           beres data ze souboru a rikas "tyhle data jsou objekt pole" a on protoze vi, jak ma pole vypadat, tak ho umi z tech dat postavit
           
           */
           
           System.out.println("Deserializace..");
          suplikDva = serializaceDeserializace.deserializace();
           
           System.out.println("Vypis po serializaci");
        for (int k = 0; k < suplikDva.length; k++) {
        
            System.out.println(Integer.toBinaryString(suplikDva[k]));
            
        }

        
        
    }
}
/* 
posloupnost = serie = serializace
vezme se objekt, ulozi se do neceho - napr do souboru
serializace objektu > cw.fel.cvut.cz/wiki/courses/b0b36pjv/tutorials/08/serializace - 8. cviceni
https://stackoverflow.com/questions/1467193/java-serialization-of-multidimensional-array



 */
