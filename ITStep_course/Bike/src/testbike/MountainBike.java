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
public class MountainBike extends Bicycle {

    private String suspension;
    private int cadence, gear, speed;

    public MountainBike(int cadence, int gear, int speed, String suspension) {
        super(cadence, gear, speed);
        this.suspension = suspension;
    }
    

    public void visit(MountainBikeService bs) {
        bs.accept(this);
    }
    
     public void visit(BicycleVisitor servis) {
        servis.accept(this);
    }
    
    @Override
     public void printDescription() {
        System.out.print("Bike is in gear " + this.gear + " with a cadence of " + this.cadence + " travelling at a speed of " + this.speed 
                + " and suspension " + this.suspension + "." + "\n");
    }

}
