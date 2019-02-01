/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

/**
 *
 * @author Student
 */
public class TimeSpan {

    private int hours;
    private int minutes;
    private int seconds;

    public TimeSpan() {
    }

    public TimeSpan(TimeSpan ts) {
        this.seconds = ts.getSeconds();
        this.minutes = ts.getMinutes();
        this.hours = ts.getHours();
    }

    public int getSeconds() {
        return this.seconds;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getHours() {
        return this.hours;
    }

    public TimeSpan(int hours, int minutes, int seconds) {
        setTime(hours, minutes, seconds);
    }

    public TimeSpan(int seconds) {
        this(seconds / 60, seconds);
    }

    public TimeSpan(int minutes, int seconds) {
        this(minutes / 60, minutes % 60, seconds);
    }

    public void setTime(int hours, int minutes, int seconds) {

        if (this.seconds >= 60 || this.seconds < 0) {

            this.seconds = 0;

        } else {
            this.seconds = seconds;
        }

        if (this.minutes >= 60 || this.minutes < 0) {

            this.minutes = 0;
        } else {
            this.minutes = minutes;
        }

        if (this.hours < 0) {
            this.hours = 0;
        } else {
            this.hours = hours;
        }

    }

    public void setHours(int hours) {
        if (hours < 24) {
            this.hours = hours;
        }
    }

    public int getTotalSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    @Override
    public String toString() {

        return "Hodiny: " + hours + "; minuty: " + minutes + "; vteřiny: " + (seconds % 60) + ";";

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final TimeSpan other = (TimeSpan) obj;
        if (this.getTotalSeconds() != other.getTotalSeconds()) {
            return false;
        }
        return true;
    }

}
