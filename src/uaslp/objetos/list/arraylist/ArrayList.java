package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class ArrayList implements List {

    private Object[] data;
    private int size;

    public ArrayList() {
        data = new Object[2];
    }


    public void addAtTail(Object data) {
        if (size == this.data.length) {
            increaseArraySize();
        }

        this.data[size] = data;
        size++;
    }

    private void increaseArraySize() {
        Object[] newArray = new Object[this.data.length * 2];

        for (int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }

        data = newArray;

    }

    public void addAtFront(Object data) {
        if (size == this.data.length) {
            increaseArraySize();
        }

        for (int i = size; i > 0; i--) {
            this.data[i] = this.data[i - 1];
        }

        this.data[0] = data;
        size++;
    }

    public boolean remove(int indexToRemove) {

        if (indexToRemove < 0 || indexToRemove >= size) {
            return false;
        }

        for (int i = indexToRemove; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;

        return true;
    }

    public void removeAll() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;

    }

    public boolean setAt(int index, Object data) {
        if (index < 0 || index >= size) {
            return false;
        }

        this.data[index] = data;

        return true;
    }

    public Object getAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return this.data[index];
    }

    public void removeAllWithValue(Object value) {

        Object[] newArray = new Object[data.length];
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

    public Iterator getIterator() {
        return new Iterator(){ // Clase anónima
                 // Inner class no estática
            private int currentIndex = 0;

            public boolean hasNext(){
                return currentIndex < size;
            }

            public Object next(){
                return data[currentIndex++];
            }
        };
    }
}
