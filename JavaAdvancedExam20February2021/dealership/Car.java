package dealership;

public class Car {

    public String manufacturer;
    public String model;
    public int year;

    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", manufacturer, model, year);
    }
}
