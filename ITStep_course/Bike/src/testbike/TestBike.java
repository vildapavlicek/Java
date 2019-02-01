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
public class TestBike {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // https://cw.fel.cvut.cz/wiki/courses/b0b36pjv/tutorials/04/start //

        Bicycle bike01;        
        MountainBike bike02;        
        RoadBike bike03;
        BasicService service = new BasicService();
        MountainBikeService mService = new MountainBikeService();
        RoadBikeService rService = new RoadBikeService();
        
        bike01 = new Bicycle(20, 10, 1);
        bike02 = new MountainBike(20, 10, 5, "Dual");
        bike03 = new RoadBike(40, 20, 8, 23);
        
        bike01.visit(service);
        bike02.visit(mService);
        bike03.visit(rService);
        
        
        
    }
    
}
