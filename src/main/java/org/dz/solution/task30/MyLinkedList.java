package org.dz.solution.task30;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {
    private Node<E> first;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        //TODO Реализовать метод
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        //TODO Реализовать метод
        return indexOf(o) != -1;
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
    public boolean add(E data) {
        Node<E> node = new Node<>(data, null);
        size++;
        if (first == null) {
            first = node;
            return true;
        }
        Node<E> current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        return true;
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
    public void clear() {
        //TODO Реализовать метод
        Node<E> current = first;
        while (current != null){
            Node<E> next = current.next;
            current.data = null;
            current.next = null;
            current = next;
            size--;
        }
        first = null;
    }

    @Override
    public E get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Points to a non-existent index = " + index +
                    " when size = " + size);
        }
        Node<E> current = first;
        int currentIndex = 0;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        return current.data;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        //TODO Реализовать метод
        int index = 0;
        Node<E> current = first;
        while (current == null){
            if (current.data == null) {
                return index;
            }
            current = current.next;
            index++;
        }
        while (current != null) {
            if (o == current.data) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        //TODO Реализовать последним
        return 0;
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
        return null;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
