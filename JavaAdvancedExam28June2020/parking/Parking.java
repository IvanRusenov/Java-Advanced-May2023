package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {

    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }

    public Car getLatestCar() {

        return data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {

            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:", type));
        data.forEach(c -> sb.append(System.lineSeparator()).append(c.toString()));
        return sb.toString();
    }
}

