package DefiningClassesExercises.A03SpeedRacing;

import java.util.List;
public class Car {
    private String model;
    private double fuelAmount = 0;
    private double fuelPerKm;
    private int traveledDistance = 0;
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelPerKm() {
        return fuelPerKm;
    }

    public void setFuelPerKm(double fuelPerKm) {
        this.fuelPerKm = fuelPerKm;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    public void setTraveledDistance(int traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public static void drive(String model, int km, List<Car> cars){

        for (Car car : cars) {

            if (car.getModel().equals(model)){

                double fuelNeeded = km * car.getFuelPerKm();

                if (car.getFuelAmount() >= fuelNeeded){

                    car.setFuelAmount(car.getFuelAmount() - fuelNeeded);
                    car.setTraveledDistance(car.getTraveledDistance() + km);

                }else{

                    System.out.println("Insufficient fuel for the drive");

                }

                break;
            }

        }

    }

}
