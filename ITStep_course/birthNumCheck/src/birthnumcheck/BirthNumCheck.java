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
public class BirthNumCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // jdeme na to
        // test RC 935726/0935
        //int[] rc = new int[]{9, 3, 5, 7, 2, 6, 0, 9, 3, 5}; //zena
        //int[] rc = new int[]{8,8,0,3,1,8,4,7,6,4};
         //int[] rc = new int[]{8,8,0,5,1,7,0,2,0,9};
        //even = 3+7+6+9+5 = 30
        //odd = 9+5+2+0+3 = 19

       //String veta = testClass.text(rc);
       int[]rc=rcInput.input();
       int testNumEven = evenAdd.evenCheck(rc);
       int testNumOdd = oddAdd.odddCheck(rc);
       boolean rcTest = rcChecker.rcCheck(testNumOdd, testNumEven);
       String pohlavi = genderChecker.genderDecider(rc);
       boolean overitelnost = rcOldCheck.rcOld(rc);
       System.out.print("Soucet sudych je: " + testNumEven + " a soucet lichych je: " + testNumOdd + "\n Rodne cislo je delitelne 11: " + rcTest + ".\n Vase pohlavi je: " + pohlavi + ".\n Jste rocnik starsi 53: " + overitelnost );
    }

}




/*
Co je hotove:
Scitani sudych
Scitani lichych
Rozliseni pohlavi
kontrola delitelnosti 11
*/
