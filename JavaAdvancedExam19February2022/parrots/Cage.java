package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
    public void add(Parrot parrot){
        if (data.size() < capacity){
            data.add(parrot);
        }
    }

    public boolean remove(String name){
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)){
                data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name){
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)){
                parrot.setAvailable(false);
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species){

        List<Parrot> toSell = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)){
                toSell.add(parrot);
                parrot.setAvailable(false);
            }
        }

       return toSell;

    }

    public int count(){
        return data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Parrots available at %s:", name));
        for (Parrot parrot : data) {
            if (parrot.isAvailable()){
                sb.append(System.lineSeparator()).append(parrot);
            }

        }
        return  sb.toString();
    }
}
