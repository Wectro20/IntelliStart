package ArrayList;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
    private int pointer = 0;
    private final int rate = 4;
    private final int size = 16;
    private T[] array = (T[]) new Object[size];

    public void add(T element) {
        if (pointer == array.length - 1) {
            resize(array.length * 2);
        }
        array[pointer++] = element;
    }

    public void remove(int index) {
        if (pointer - index >= 0) {
            System.arraycopy(array, index + 1, array, index, pointer - index);
        }
        array[pointer] = null;
        pointer--;
        if (array.length > size && pointer < array.length / rate) {
            resize(array.length / 2);
        }
    }

    public void clear() {
        Arrays.fill(array, null);
        pointer = 0;
    }

    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        T[] newArray = (T[]) new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public String toString() {
        Object[] newArray = Arrays.stream(array).
                filter(Objects::nonNull).toArray();
        return Arrays.toString(newArray);
    }
}
