package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {

    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant){
        if (data.size()<capacity){
            data.add(elephant);
        }
    }

    public boolean remove(String name){
        for (Elephant elephant : data) {
            if (elephant.getName().equals(name)){
                data.remove(elephant);
                return true;
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom){
        for (Elephant elephant : data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)){
                return elephant;
            }
        }
        return null;
    }

    public Elephant getOldestElephant(){
       return data.stream().max(Comparator.comparing(Elephant::getAge)).orElse(null);
    }

    public int getAllElephants(){
        return data.size();
    }

    public String getReport(){

        StringBuilder sb = new StringBuilder();

        sb.append("Saved elephants in the park:");
        data.forEach(elephant -> sb.append(System.lineSeparator())
               .append(String.format("%s came from: %s"
                        , elephant.getName(), elephant.getRetiredFrom())));

        return sb.toString();
    }
}
