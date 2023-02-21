package org.dz.solution.task29;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyArrayList implements List<Integer> {
    private final int DEFAULT_ARRAY_CAPACITY = 3;
    private Integer[] array;
    private int size;
    private int index;

    public MyArrayList() {
        array = new Integer[DEFAULT_ARRAY_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Integer number = (Integer) o;
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], number)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        if (size >= array.length) {
            Integer[] newArray = new Integer[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[index] = integer;
        size++;
        index++;
        return true;
    }

    public int getCapacity() {
        return array.length;
    }

    @Override
    public boolean remove(Object o) {
        Integer number = (Integer) o;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(number)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<Integer> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super Integer> c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {
        for (int tempSize = size, i = size = 0; i < tempSize; i++) {
            array[i] = null;
        }
    }

    @Override
    public Integer get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " > " + size + " Size");
        }
        return array[index];
    }

    @Override
    public Integer set(int index, Integer element) {
        //TODO написать
        return null;
    }

    @Override
    public void add(int index, Integer element) {

    }

    @Override
    public Integer remove(int index) {
        int temp = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return temp;
    }

    @Override
    public int indexOf(Object o) {
        Integer number = (Integer) o;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(number)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        //TODO написать
        return 0;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        //TODO написать
        return null;
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return List.super.spliterator();
    }
}
