package org.dz.solution.helper;

import java.util.List;

public abstract class MyAbstractList<E> implements List<E> {
    protected static final int INDEX_WHEN_NOTHING_FOUND = -1;
    protected int size;

    protected void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds 0 - " + size);
        }
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
        return indexOf(o) != -1;
    }

}
