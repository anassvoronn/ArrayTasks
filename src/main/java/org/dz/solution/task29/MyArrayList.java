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
        // вернет true если (number) число есть в списке, если нет то false
        return number == 0;
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

    }

    @Override
    public Integer get(int index) {
        return array[index];
    }

    @Override
    public Integer set(int index, Integer element) {
        return null;
    }

    @Override
    public void add(int index, Integer element) {

    }

    @Override
    public Integer remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
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
        return null;
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return List.super.spliterator();
    }
}
