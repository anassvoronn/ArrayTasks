package org.dz.solution.task29;

import org.dz.solution.helper.MyAbstractList;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyArrayList<E> extends MyAbstractList<E> implements List<E> {
    private final int DEFAULT_ARRAY_CAPACITY = 3;
    private Object[] array;

    public MyArrayList() {
        array = new Object[DEFAULT_ARRAY_CAPACITY];
    }

    public MyArrayList(int arrayCapacity) {
        array = new Object[arrayCapacity];
    }

    @Override
    public Iterator<E> iterator() {
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
    public boolean add(E element) {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = element;
        size++;
        return true;
    }

    public int getCapacity() {
        return array.length;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == INDEX_WHEN_NOTHING_FOUND) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        E temp = (E) array[index];
        shiftToLeft(index);
        array[size - 1] = null;
        size--;
        return temp;
    }

    private void shiftToLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        //TODO написать метод
        for (int i = 0; i < size; i++) {
            contains(true);
        }
        return false;
    }


    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }


    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public void replaceAll(UnaryOperator<E> operator) {
    }

    @Override
    public void sort(Comparator<? super E> c) {
    }

    @Override
    public void clear() {
        array = new Integer[array.length];
        size = 0;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return (E) array[index];
    }

    @Override
    public E set(int index, E element) {
        validateIndex(index);
        E number = (E) array[index];
        array[index] = element;
        return number;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], o)) {
                return i;
            }
        }

        return INDEX_WHEN_NOTHING_FOUND;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(array[i], o)) {
                return i;
            }
        }
        return INDEX_WHEN_NOTHING_FOUND;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        //TODO найти баг
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex " + fromIndex + " > " + toIndex + " toIndex");
        }
        validateIndex(fromIndex);
        validateIndex(toIndex);
        int arraySize = toIndex - fromIndex;
        MyArrayList<E> list = new MyArrayList<>(arraySize);
        for (int i = fromIndex; i < toIndex; i++) {
            //list.add(arraySize[fromIndex]);
        }
        return (List<E>) list;
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

}
