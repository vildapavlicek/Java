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
public class BasicService implements BicycleVisitor {

    /**
     *
     * @param bike
     */
    /*public void accept(BicycleVisitor bike) {
        System.out.println("Fixing Bicycle");
    }*/

    @Override
    public void accept(MountainBike b) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void accept(RoadBike b) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void accept(Bicycle b) {
        System.out.println("fixing Bicycle"); 
    }

}
