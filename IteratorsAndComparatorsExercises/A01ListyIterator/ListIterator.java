package IteratorsAndComparatorsExercises.A01ListyIterator;

import java.util.Arrays;
import java.util.List;

public class ListIterator {
    private List<String> elements;
    private int index;

    public ListIterator(String... strings) {

        this.elements = Arrays.asList(strings);
        this.index = 0;

    }

    public boolean hasNext (){
        return index < elements.size() - 1;
    }

    public void Print(){
        System.out.println(elements.get(index));
    }

    public boolean Move(){

       if (hasNext()){
           index++;
           return true;
       }
       return false;

    }
}
