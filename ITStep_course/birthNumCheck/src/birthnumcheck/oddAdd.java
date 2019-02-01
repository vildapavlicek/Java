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
public class oddAdd {
      public static int odddCheck(int[] rc) {

        int oddAddRes = 0;
        int i = 0;
        while (i < rc.length) {

            oddAddRes = oddAddRes + rc[i];
            i = i + 2;
        }

        return oddAddRes;
      }
}
