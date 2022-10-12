package uaslp.objetos.list;

public interface List {
    void addAtTail(Object data);

    void addAtFront(Object data);

    boolean remove(int index);

    void removeAll();

    /**
     * Permite colocar un elemento en un índice específico de la lista.
     *
     * @param index Indice del elemento a insertar
     * @param data Dato a colocar en la lista
     * @return true si el indice era válido, false de lo contrario
     */
    boolean setAt(int index, Object data);

    Object getAt(int index);

    void removeAllWithValue(Object data);

    int getSize();

    Iterator getIterator();
}
