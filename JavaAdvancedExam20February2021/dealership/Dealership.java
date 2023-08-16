package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {

    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return data.removeIf(car -> car.manufacturer.equals(manufacturer) && car.model.equals(model));

    }

    public Car getLatestCar() {
        return data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {

        return data.stream()
                .filter(car -> car.model.equals(model) && car.manufacturer.equals(manufacturer))
                .collect(Collectors.toList())
                .get(0);

    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(" The cars are in a car dealership %s:", name));
        data.forEach(car -> sb.append(System.lineSeparator()).append(car.toString()));
        return sb.toString();
    }


}
