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
public class Car {

    private String manufacturer;
    private String modelName;
    private int year;
    private int speed;
    private Engine engine;
    private ServiceBook serviceBook;
    private static int counter = 0;

    public Car(String manufacturer, String modelName, int year, int speed, String engine) {

        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.year = year;
        this.speed = speed;

        this.engine = new Engine(engine);
        this.serviceBook = new ServiceBook(this);

        counter++;
    }

    public void setServiceBook(ServiceBook serviceBook) {
        this.serviceBook = serviceBook;

    }

    public ServiceBook getServiceBook() {
        return this.serviceBook;

    }

    public String getManufacturer(String manufacturer) {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName(String modelName) {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getYear(int year) {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    protected void finalize() throws Throwable {
        try {
            counter--;
        } finally {
            super.finalize();
        }
    }

    @Override
    public String toString() {
        return "Manufacturer: " + manufacturer + "\n" + "Model name: " + modelName + "\n" + "Rok vyroby: " + year + "\n" + "Rychlost (km/h): "
                + speed + "\n" + "Service records: " + this.serviceBook.getServiceRecords();
    }

}
