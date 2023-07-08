package GenericsExercises.A04GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box <T>{

    private List<T> list;

    public Box() {
       list = new ArrayList<>();
    }

    public List<T> getList() {
        return list;
    }

    public void swap(int index1, int index2){

        Collections.swap(this.list,index1,index2);

    }
}
