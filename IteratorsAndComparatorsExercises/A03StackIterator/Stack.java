package IteratorsAndComparatorsExercises.A03StackIterator;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Stack <T> implements Iterable<T>{

    private ArrayDeque<T> stack;

    public Stack() {
        this.stack = new ArrayDeque<>();

    }

    public void Push(T element) {

        stack.push(element);

    }

    public T Pop(){




           return stack.pop();

    }

    @Override
    public Iterator<T> iterator() {
      return stack.iterator();
    }
}
