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
public class evenAdd {

    public static int evenCheck(int[] rc) {

        int evenAddRes = 0;
        int i = 1;
        while (i < rc.length) {

            evenAddRes = evenAddRes + rc[i];
            i = i + 2;
        }

        return evenAddRes;
    }

}
