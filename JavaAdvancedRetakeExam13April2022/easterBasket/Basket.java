package easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Egg> data;
    private int capacity;
    private String material;

    public Basket(String material, int capacity) {
        this.capacity = capacity;
        this.material = material;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg){
        if (data.size()<capacity){
            data.add(egg);
        }
    }

    public boolean removeEgg(String color){
        for (Egg egg : data) {
            if (egg.getColor().equals(color)){
                data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg(){
       return data.stream().min((f,s)-> Integer.compare(s.getStrength(),f.getStrength())).orElse(null);
    }

    public Egg getEgg(String color) {
        for (Egg egg : data) {
            if (egg.getColor().equals(color)){
                return egg;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String report(){

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s basket contains:", material));
        data.forEach(e -> sb.append(System.lineSeparator()).append(e.toString()));

      return sb.toString();
    }
}
