package GenericsExercises.A01GenericBox;

public class Box<T> {


    private T info;

    public Box(T info) {
        this.info = info;
    }

    @Override
    public String toString(){
        return String.format("%s: %s", info.getClass().toString().substring(6), info);
    }
}
