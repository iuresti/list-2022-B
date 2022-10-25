package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;

class ArrayListIterator<T> implements Iterator<T> {

    private ArrayList<T> arrayList;
    private int currentIndex = 0;

    public ArrayListIterator(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    public boolean hasNext() {
        return currentIndex < arrayList.getSize();
    }

    public T next() {
        return arrayList.getAt(currentIndex++);
    }
}
