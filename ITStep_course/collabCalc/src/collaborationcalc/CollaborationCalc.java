/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationcalc;

/**
 *
 * @author Student
 */
public class CollaborationCalc {

    /**
     * @param args the command line arguments
     *
     * Naprogramování kalkulačky
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int a = 2;
        int b = 2;
    }

    // metoda pro soucet - ja
    public static int soucet(int a, int b) {

        int num = a + b;
        return num;
    }

    // metoda pro rozdil - odecitani
    public static int rozdil(int a, int b) {

        int num = a-b;
        return num;
    }

    // metoda pro nasobeni
    public static int nasobeni(int a, int b) {
        int num = a*b;
        return num;
    }

    // metoda pro deleni - ja
    public static int deleni(int a, int b) {
               
        int num = a / b;
        return num;
    }

}
