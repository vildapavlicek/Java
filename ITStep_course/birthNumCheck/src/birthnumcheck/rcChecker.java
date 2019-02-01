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
public class rcChecker {

    public static boolean rcCheck(int oddAddRes, int evenAddRes) {

        int numCheck;
        if (oddAddRes > evenAddRes) {

            numCheck = oddAddRes - evenAddRes;
        } else {
            numCheck = evenAddRes - oddAddRes;
        }

        return (numCheck % 11) == 0;

    }
}
