package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;

class ArrayListIterator implements Iterator {

    private ArrayList arrayList;
    private int currentIndex = 0;

    public ArrayListIterator(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public boolean hasNext() {
        return currentIndex < arrayList.getSize();
    }

    public Object next() {
        return arrayList.getAt(currentIndex++);
    }
}
