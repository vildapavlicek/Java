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
public class Tahac extends MotoroveVozidlo {

    protected int max_hm_navesu;

    public Tahac(String vykon_motoru, int pocet_mist_k_sezeni, int max_rychlost, int max_hm_navesu) {
        super(vykon_motoru, pocet_mist_k_sezeni, max_rychlost);
        this.max_hm_navesu = max_hm_navesu;
    }

    public void setMax_hm_navesu(int max_hm_navesu) {
        this.max_hm_navesu = max_hm_navesu;
    }

    public int getMax_hm_navesu() {
        return this.max_hm_navesu;
    }

}
