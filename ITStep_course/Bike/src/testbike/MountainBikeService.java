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
public class MountainBikeService extends BasicService implements BicycleVisitor {

    
    @Override
    public void accept(Bicycle bike) {
        System.out.println("Fixing Bicycle");
    }
   
    @Override
    public void accept(MountainBike bike) {
        System.out.println("Fixing MountainBike");
    }
}
