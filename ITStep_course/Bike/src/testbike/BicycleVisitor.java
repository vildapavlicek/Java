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
public interface BicycleVisitor {
    
    public void accept(Bicycle b);
    public void accept(MountainBike b);
    public void accept(RoadBike b);
    
}
