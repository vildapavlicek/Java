/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuckbook;

import java.util.Scanner;

/**
 *
 * @author Vilda
 */
public class newInput {

    private String inputStr;
    private int inputInt;
    private String name;
    private String asl; //Age/Sex/Location
    private int height;
    private int boobs;
    private int weight;
    private int rating; // 1-10

    private Courtesan temp;

    public Courtesan getNewInput() {

        if ("Y".equals(inputStr)) {

            Courtesan temp = new Courtesan(this.name, this.asl, this.height, this.boobs, this.weight, this.rating);

            return temp;

        }
        return null;

    }

    public String getEntry() {
        System.out.println("Chcete zadat novy znaznam? Y/N");
        inputStr = stringSc();
        return inputStr;
    }

    public String getName() {
        System.out.println("Zadejte jmeno");
        this.name = stringSc();
        return this.name;
    }

    public String getAsl() {
        System.out.println("Zadejte ASL");
        this.asl = stringSc();
        return this.asl;
    }

    public int getHeight() {
        System.out.println("Zadejte vysku");
        this.height = intSc();
        return this.height;
    }

    public int getWeight() {
        System.out.println("Zadejte vahu");
        this.weight = intSc();
        return this.weight;
    }

    public int getBoobs() {
        System.out.println("Zadejte velikost prstou (v cislech)");
        this.boobs = intSc();
        return this.boobs;
    }

    public int getRating() {
        System.out.println("Zadejte hodnoceni (1-10)");
        this.rating = intSc();
        return this.rating;
    }

    private String stringSc() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return input;
    }

    private int intSc() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        return input;
    }

}
