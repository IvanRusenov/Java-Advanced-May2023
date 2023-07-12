package GenericsExercises.A08CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> values;

    public CustomList() {
        values = new ArrayList<>();
    }

    public void addElement(T element) {
       values.add(element);
    }

    public T remove(int index) {

      return values.remove(index);

    }

    public boolean contains(T element) {
        return values.contains(element);
    }

    public void swap(int index1, int index2) {

        Collections.swap(values, index1, index2);
    }

    public int countGreaterThan(T element) {

        return (int)values.stream().filter(e -> e.compareTo(element) > 0).count();

    }

    public T getMax() {
        return values.stream().max(Comparator.naturalOrder()).get();
    }

    public T getMin() {
        return values.stream().min(Comparator.naturalOrder()).get();
    }
    public T get(int index){
        return values.get(index);
    }
    public int size(){
        return values.size();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (T el : values) {
            sb.append(String.format("%s%n",el.toString()));
        }
        return sb.toString().trim();
    }


}
