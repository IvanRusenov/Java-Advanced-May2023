package JavaAdvancedRetakeExam12April2023.magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {

    private List<Cloth> data;
    private String type;
    private int capacity;

    public Magazine(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void addCloth(Cloth cloth) {

        if (this.data.size() < capacity) {

            this.data.add(cloth);

        }
    }

    public boolean removeCloth(String color) {

        for (Cloth cloth : data) {
            if (cloth.getColor().equals(color)) {
                data.remove(cloth);
                return true;
            }
        }
        return false;
    }

    public Cloth getSmallestCloth() {
        return this.data.stream().min(Comparator.comparing(Cloth::getSize)).orElse(null);

    }

    public Cloth getCloth(String color) {

        return data.stream().filter(cloth -> cloth.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s JavaAdvancedRetakeExam12April2023.magazine contains:", type));
        data.stream().forEach(cloth -> sb.append(System.lineSeparator()).append(cloth.toString()));

        return sb.toString();

    }
}
