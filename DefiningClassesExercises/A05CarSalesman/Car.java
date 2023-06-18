package DefiningClassesExercises.A05CarSalesman;

public class Car {

    //model, engine, weight, and color
    //FordFocus V4-33 1300 Silver
    //FordMustang V8-101
    //VolkswagenGolf V4-33 Orange

    private String model;
    private Engine engine;
    private String weight;//optional
    private String color;//optional


    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color ="n/a";
    }

    public Car(String model, Engine engine, String weight) {
        this(model,engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    @Override
    public String toString(){

        return String.format("%s:\n" +
                "%s:\n" +
                "Power: %s\n" +
                "Displacement: %s\n" +
                "Efficiency: %s\n" +
                "Weight: %s\n" +
                "Color: %s"
                , this.model, this.engine.getModel(), this.engine.getPower(),  this.engine.getDisplacement()
                , this.engine.getEfficiency(), this.weight, this.color);
    }
}
