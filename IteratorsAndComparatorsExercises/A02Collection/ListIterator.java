package IteratorsAndComparatorsExercises.A02Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListIterator implements Iterable<String> {
    private List<String> elements;
    private int index;

    public ListIterator(String... strings) {

        this.elements = Arrays.asList(strings);
        this.index = 0;

    }

    public boolean hasNext() {
        return index < elements.size() - 1;
    }

    public void Print() {
        System.out.println(elements.get(index));
    }

    public void PrintAll() {
        System.out.println(String.join(" ", elements));
    }

    public boolean Move() {

        if (hasNext()) {
            index++;
            return true;
        }
        return false;

    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return index < elements.size();
            }


            @Override
            public String next() {

                return elements.get(index++);

            }
        };
    }
}
