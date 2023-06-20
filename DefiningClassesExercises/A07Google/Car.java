package DefiningClassesExercises.A07Google;

public class Car {

   private String model;
    private String carSpeed;

    public Car(String model, String carSpeed) {
        this.model = model;
        this.carSpeed = carSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(String carSpeed) {
        this.carSpeed = carSpeed;
    }
}
