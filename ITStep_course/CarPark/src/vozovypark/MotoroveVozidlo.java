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
public class MotoroveVozidlo {

    protected String vykon_motoru;
    protected int pocet_mist_k_sezeni;
    protected int max_rychlost;

    public MotoroveVozidlo(String vykon_motoru, int pocet_mist_k_sezeni, int max_rychlost) {
        this.vykon_motoru = vykon_motoru;
        this.pocet_mist_k_sezeni = pocet_mist_k_sezeni;
        this.max_rychlost = max_rychlost;
    }

    public void setVykon_motoru(String vykon_motoru) {
        this.vykon_motoru = vykon_motoru;
    }

    public void setPocet_mist_k_sezeni(int pocet_mist_k_sezeni) {
        this.pocet_mist_k_sezeni = pocet_mist_k_sezeni;
    }

    public void setMax_rychlost(int max_rychlost) {
        this.max_rychlost = max_rychlost;
    }

    public String getVykon_motoru() {
        return this.vykon_motoru;
    }

    public int getPocet_mist_k_sezeni() {
        return this.pocet_mist_k_sezeni;
    }

    public int getMax_rychlost() {
        return this.max_rychlost;
    }
}
