package DefiningClassesLab.A02Constructors;

public class Car {

    private String brand;
    private String model;
    private int hp;


    public Car(String brand, String model, int hp) {

        this.setBrand(brand);
        this.setModel(model);
        this.setHp(hp);

    }

    public Car(String brand) {
        this("unknown", "unknown", -1);
        this.setBrand(brand);
    }

    public Car (){
        this("unknown");
    }

      public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHp());
    }
}
