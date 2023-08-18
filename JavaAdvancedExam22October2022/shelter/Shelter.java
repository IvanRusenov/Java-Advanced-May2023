package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Shelter {

    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }

    public void add(Animal animal){
        if (data.size() < capacity){
            data.add(animal);
        }
    }

    public boolean remove(String name){
        for (Animal animal : data) {
            if (animal.getName().equals(name)){
                data.remove(animal);
                return true;
            }
        }
        return  false;
    }

    public Animal getAnimal(String name, String caretaker){
        for (Animal animal : data) {
            if (animal.getName().equals(name)&& animal.getCaretaker().equals(caretaker)){
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal(){
        return data.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){

        StringBuilder sb = new StringBuilder();

        sb.append("The shelter has the following animals:");
        data.forEach(e -> sb.append(System.lineSeparator())
                .append(String.format("%s %s", e.getName(), e.getCaretaker())));
        return  sb.toString();
    }


}
