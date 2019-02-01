/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

import java.util.Objects;

/**
 *
 * @author Student
 */
public class RaceResult {

    private Car car;
    private TimeSpan timeSpan;

    public RaceResult(Car car, TimeSpan timeSpan) {
        this.car = car;
        this.timeSpan = timeSpan;
    }

    public Car getCar() {
        return this.car;
    }

    public TimeSpan getTimeSpan() {
        return this.timeSpan;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.timeSpan);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final RaceResult other = (RaceResult) obj;
        if (!Objects.equals(this.timeSpan, other.timeSpan)) {
            return false;
        }
        return true;
    }

}
