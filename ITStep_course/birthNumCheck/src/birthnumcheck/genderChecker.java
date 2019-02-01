/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birthnumcheck;

/**
 *
 * @author Student
 */
public class genderChecker {

    public static String genderDecider(int[] rc) {
        String muz = "muz";
        String zena = "zena";
        int month = rc[2];

        if (month > 4) {

            return zena;
        } else {
            return muz;
        }

    }
}
