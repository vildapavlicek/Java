/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver;

/**
 *
 * @author Student
 */
public class Person {
    // "name":"Vilda","age":55,"location":"Team Nowhere"
    private String name;
    private int age;
    private String location;
    
    @Override
    public String toString(){
    return  "name: " + this.name + "; age:  " + this.age + "; location: " + this.location; 
    }
}
