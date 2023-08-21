package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {

    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet){
        if (data.size()<capacity){
            data.add(pet);
        }
    }
    public boolean remove(String name){
       return data.removeIf(e->e.getName().equals(name));
    }

    public Pet getPet(String name, String owner){
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(" The grooming salon has the following clients:");
        data.forEach(e-> sb.append(System.lineSeparator()).append(String.format("%s %s",e.getName(), e.getOwner())));
        return sb.toString();
    }
}
