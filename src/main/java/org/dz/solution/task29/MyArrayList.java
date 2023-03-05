package org.dz.solution.task29;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyArrayList implements List<Integer> {
    private static final int INDEX_WHEN_NOTHING_FOUND = -1;
    private final int DEFAULT_ARRAY_CAPACITY = 3;
    private Integer[] array;
    private int size;
    private int index;

    public MyArrayList() {
        array = new Integer[DEFAULT_ARRAY_CAPACITY];
    }

    public MyArrayList(int arrayCapacity) {
        array = new Integer[arrayCapacity];
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
        return indexOf(number) != -1;
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
        if (size == array.length) {
            Integer[] newArray = new Integer[array.length * 2];
            for (int i = 0; i < size; i++) {
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
        int index = indexOf(number);
        if (index == INDEX_WHEN_NOTHING_FOUND) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        int temp = array[index];
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
        array = new Integer[array.length];
        size = 0;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public Integer set(int index, Integer element) {
        //TODO написать замену элемента в указанной месте index на переданный element
        //[1, -4, 0, 1, 8] если индек = 1, а элемент = null [1, null, 0, 1, 8] вернуть -4
        validateIndex(index);
        int number = array[index];
        array[index] = element;
        return number;
    }

    @Override
    public void add(int index, Integer element) {

    }

    @Override
    public int indexOf(Object o) {
        Integer number = (Integer) o;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(number)) {
                return i;
            }
        }

        return INDEX_WHEN_NOTHING_FOUND;
    }

    @Override
    public int lastIndexOf(Object o) {
        //TODO написать возвращение последнего вхождения указаного значения
        //[1, -4, 0, 1, 8] если приходит 1 то вернуть 3(его индекс)
        Integer number = (Integer) o;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(array[i], number)) {
                return i;
            }
        }
        return -1;
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
        //TODO вернуть содержимое данного массива
        //[1, -4, 0, 1, 8]
        validateIndex(fromIndex);
        validateIndex(toIndex);
        //Высчитать длину
        //Создать массив нужной длины
        //Заполнить массив
        //вернуть его
        //ArrayList в конструкторе написать валидацию чтобы копэсити не был отрицательным
        //Удалить поле индекс
        int arraySize = toIndex - fromIndex;
        MyArrayList list = new MyArrayList(arraySize);
        for (int i = 0; i < size; i++) {
            if (i == fromIndex) {

            }
        }
        return new MyArrayList(); //должен содержать [1, -4] если fromIndex и toIndex = 0 и 2
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return List.super.spliterator();
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds 0 - " + size);
        }
    }
}
