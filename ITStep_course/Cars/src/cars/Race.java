/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class Race {

    private int length = 0;
    private boolean ready = false;
    private int time;
    private int speed;
    private ArrayList<RaceResult> results = new ArrayList<RaceResult>();
    private ArrayList<Car> cars = new ArrayList<Car>();

    public Race(int len) {
        this.length = len;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void start() {
        this.ready = true;
    }

    public int getLength() {
        return this.length;
    }

    private void getResults() {
        if (!ready) {
            return;
        }
        // čas ujetí závodu pro každé auto
        //výsledek seřadí       
        //t = s/v
        for (Car tmpcar : cars) // z array cars beru jednotlive prvky a kazdy ten prvek si ulozim do tmpcar
        {
            results.add(
                    new RaceResult(
                            tmpcar, new TimeSpan(
                                    this.length / tmpcar.getSpeed())));
        }

    }

}


// CRM na milenky, bude se to ukladat do souboru serializovane
// pri kazdem spusteni se nacte ze souboru a deserializuje se
// na serializaci statickou tridu
// trida zeny - vlastni objekt zena
//extra trida staticka - serializace deserializace
//napsat toString
//instance naprat do ArrayListu