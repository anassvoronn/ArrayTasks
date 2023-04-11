package org.dz.solution.task30;

import org.dz.solution.helper.MyAbstractList;

import java.util.*;

public class MyLinkedList<E> extends MyAbstractList<E> implements List<E> {
    private Node<E> first;

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
        Node<E> previous = null;
        Node<E> current = first;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                if (current == first) {
                    first = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
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
        Node<E> current = first;
        while (current != null) {
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
        validateIndex(index);
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
        Node<E> previous = null;
        Node<E> current = first;
        int currentIndex = 0;
        E oldValue;
        while (current != null) {
            if (currentIndex == index) {
                 oldValue = current.data;
                 current.data = element;
                 return oldValue;
            }
            previous = current;
            current = current.next;
            currentIndex++;
        }
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        Node<E> previous = null;
        Node<E> current = first;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                if (previous == null) {
                    first = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.data;
            }
            previous = current;
            current = current.next;
            currentIndex++;
        }
        throw new IllegalStateException("Reached unreachable point with index = " + index + " size = " + size);
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<E> current = first;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return INDEX_WHEN_NOTHING_FOUND;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size;
        Node<E> current = first;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return index;
            }
            current = current.next;
            index--;
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
