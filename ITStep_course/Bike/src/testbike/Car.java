/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbike;

import java.util.ArrayList;

/**
 *
 * @author Vilda
 */
public class Car implements BicycleVisitor {
    
    ArrayList<BicycleHolder> carHolders = new ArrayList<>();


    @Override
    public void accept(Bicycle b) {
        System.out.println("fixing Bicycle"); 
    }

    @Override
    public void accept(MountainBike b) {
        System.out.println("fixing MountainBike"); 
    }

    @Override
    public void accept(RoadBike b) {
        System.out.println("fixing RoadBike"); 
    }
    
    
}
