/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vozovypark;

/**
 *
 * @author Student
 */
public class VozovyPark {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        OsobniAuto skodovka;
        Autobus veolia;
        Ambulance sanitka;
        Tahac tatra;
        
        skodovka = new OsobniAuto("450 koni", 5, 220, 400);
        veolia = new Autobus("800 koni", 40, 120, 40);
        sanitka = new Ambulance("500 koni", 3, 250, 2);
        tatra = new Tahac("1250 koni", 3, 80, 250);
    }
    
}
