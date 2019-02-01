/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuckbook;

/**
 *
 * @author Vilda
 */
public class Courtesan implements java.io.Serializable {

    private String name;
    private String asl; //Age/Sex/Location
    private int height;
    private int boobs;
    private int weight;
    private int rating; // 1-10

    public Courtesan(String name, String asl, int height, int boobs, int weight, int rating) {
        this.name = name;
        this.asl = asl;
        this.height = height;
        this.boobs = boobs;
        this.weight = weight;
        this.rating = rating;
    }
// SETTERS //

    public void setName(String name) throws Exception {
        if (!name.matches("[a-zA-Z]+")) {
            throw new Exception("Chyba  v zadaní jemna.");
        }
        this.name = name;
    }

    public void setAsl(String asl) throws Exception {
        if (!asl.matches("[a-zA-Z]/+")) {
            throw new Exception("Chyba  v zadaní A/S/L.");
        }
        this.asl = asl;
    }

    public void setHeight(int height) throws Exception {
        if (height < 135) {
            throw new Exception("Ses na liliputky, nebo pedofil?");
        }
        this.height = height;
    }

    public void setBoobs(int boobs) throws Exception {
        if (boobs < 0) {
            throw new Exception("Zadej velikost poprsi v cislech");
        }
        this.boobs = boobs;
    }

    public void setWeight(int weight) throws Exception {
        if (weight < 30) {
            throw new Exception("To je horsi nez anorexie");
        }
        this.weight = weight;
    }

    public void setRating(int rating) throws Exception {
        if (rating < 0 || rating > 10) {
            throw new Exception("Bud je fakt hnusna, nebo je to totalni hobyhe");
        }
        this.rating = rating;
    }

    // GETTERS //
    public String getName() {
        return this.name;
    }

    public String getAsl() {
        return this.asl;
    }

    public int getHeight() {
        return this.height;
    }

    public int getBoobs() {
        return this.boobs;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getRating() {
        return this.rating;
    }

    // OVERRIDE //
    @Override
    public String toString() {
        return "Jmeno: " + this.name + "; Age/Sex/Location: " + this.asl + "; Velikost prsou: " + this.boobs + "; Vyska: " + this.height + "; Vaha: "
                + this.weight + "; Hodnoceni: " + this.rating + " z 10";
    }
}
