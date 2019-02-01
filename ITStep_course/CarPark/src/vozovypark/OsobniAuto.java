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
public class OsobniAuto extends MotoroveVozidlo {
   protected int velikost_kufru;

    public OsobniAuto(String vykon_motoru, int pocet_mist_k_sezeni, int max_rychlost, int velikost_kufru) {
        super(vykon_motoru, pocet_mist_k_sezeni, max_rychlost);
        this.velikost_kufru = velikost_kufru;
    }
    
    public void setVelikost_kufru(int velikost_kufru){
    this.velikost_kufru = velikost_kufru;
    }
    
    public int getVelikost_kufru(){
    return this.velikost_kufru;
    }
    
    
}
