/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbike;

/**
 *
 * @author Vilda
 */
public class Bicycle {

    private int cadence;
    private int gear;
    private int speed;

    public Bicycle(int cadence, int gear, int speed) {
        this.cadence = cadence;
        this.gear = gear;
        this.speed = speed;
    }

    public void visit(BasicService bs) {
        bs.accept(this);
    }

    public void visit(BicycleVisitor servis) {
        servis.accept(this);
    }

//Bike is in gear 1 with a cadence of 20 and travelling at a speed of 10. 
    public void printDescription() {
        System.out.print("Bike is in gear " + this.gear + " with a cadence of " + this.cadence + " and travelling at a speed of " + this.speed + "." + "\n");
    }

}
