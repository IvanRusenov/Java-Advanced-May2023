package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Clinic {

    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void add(Pet pet){
        if (data.size() < capacity){
            data.add(pet);
        }
    }

    public boolean remove(String name){
        return  data.removeIf(p->p.getName().equals(name));
    }

    public Pet getPet(String name, String owner){
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet(){
        return  data.stream().max(Comparator.comparing(Pet::getAge)).orElse(null);
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){

        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:");
        data.forEach(p-> sb.append(System.lineSeparator()).append(String.format("%s %s", p.getName(), p.getOwner())));
        return sb.toString();
    }

}
