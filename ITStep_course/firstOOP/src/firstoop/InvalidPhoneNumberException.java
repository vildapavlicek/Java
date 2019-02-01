/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstoop;

/**
 *
 * @author Student
 */
public class InvalidPhoneNumberException extends Exception {

    private int myErrorNumber;

    public InvalidPhoneNumberException(int myErrorNumber, String message) {

        super(message);
        this.myErrorNumber = myErrorNumber;
    }

    public int getMyErrorNumber() {
        return myErrorNumber;
    }
}
