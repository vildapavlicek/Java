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
public class RoadBike extends Bicycle {

    private int tireWidth;
    private int cadence, gear, speed;

    public RoadBike(int cadence, int gear, int speed, int tireWidth) {
        super(cadence, gear, speed);
        this.tireWidth = tireWidth;
    }

    public void visit(RoadBikeService bs) {
        bs.accept(this);
    }
    
    @Override
    public void printDescription() {
        System.out.print("Bike is in gear " + this.gear + " with a cadence of " + this.cadence + " travelling at a speed of " + this.speed
                + " and tireWidth " + this.tireWidth + "mm" + "." + "\n");
    }

}
