package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {

    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicles.size() < capacity) {
            vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        return vehicles.removeIf(v -> v.getVIN().equals(vin));
    }

    public int getCount() {
        return vehicles.size();
    }

    public Vehicle getLowestMileage() {
        return vehicles.stream().min(Comparator.comparing(Vehicle::getMileage)).orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:");
        vehicles.forEach(v -> sb.append(System.lineSeparator()).append(v.toString()));
        return sb.toString();
    }
}
