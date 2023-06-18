package DefiningClassesExercises.A05CarSalesman;

public class Engine {

    //model, power, displacement, and efficiency
    //V8-101 220 50
    //V4-33 140 28 B

    private String model;
    private int power;
    private String displacement;//optional
    private String efficiency;//optional

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, String displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String displacement, String efficiency) {
        this(model, power, displacement);
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
