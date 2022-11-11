package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public class ArrayList<T> implements List<T> {

    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        data = (T[]) new Object[2];
    }


    public void addAtTail(T data) throws NullNotAllowedException {

        if (data == null) {
            throw new NullNotAllowedException();
        }

        if (size == this.data.length) {
            increaseArraySize();
        }

        this.data[size] = data;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void increaseArraySize() {
        T[] newArray = (T[]) new Object[this.data.length * 2];

        System.arraycopy(data, 0, newArray, 0, data.length);

        data = newArray;

    }

    public void addAtFront(T data) throws NullNotAllowedException {

        if (data == null) {
            throw new NullNotAllowedException();
        }

        if (size == this.data.length) {
            increaseArraySize();
        }

        for (int i = size; i > 0; i--) {
            this.data[i] = this.data[i - 1];
        }

        this.data[0] = data;
        size++;
    }

    public void remove(int indexToRemove) throws WrongIndexException {

        if (indexToRemove < 0 || indexToRemove >= size) {
            throw new WrongIndexException();
        }

        for (int i = indexToRemove; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
    }

    public void removeAll() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;

    }

    public void setAt(int index, T data) throws WrongIndexException, NullNotAllowedException {
        if (data == null) {
            throw new NullNotAllowedException();
        }

        if (index < 0 || index >= size) {
            throw new WrongIndexException();
        }

        this.data[index] = data;
    }

    public T getAt(int index) throws WrongIndexException {
        if (index < 0 || index >= size) {
            throw new WrongIndexException();
        }

        return this.data[index];
    }

    @SuppressWarnings("unchecked")
    public void removeAllWithValue(T value) {

        T[] newArray = (T[]) new Object[data.length];
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (!data[i].equals(value)) {
                newArray[count++] = data[i];
            }
        }

        this.data = newArray;
        size = count;

    }

    public int getSize() {
        return size;
    }

    public Iterator<T> getIterator() {
        return new Iterator<T>() { // Clase anónima
            // Inner class no estática
            private int currentIndex = 0;

            public boolean hasNext() {
                return currentIndex < size;
            }

            public T next() {
                return data[currentIndex++];
            }
        };
    }
}
