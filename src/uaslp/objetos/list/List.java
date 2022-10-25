package uaslp.objetos.list;

public interface List<T> {
    void addAtTail(T data);

    void addAtFront(T data);

    boolean remove(int index);

    void removeAll();

    /**
     * Permite colocar un elemento en un índice específico de la lista.
     *
     * @param index Indice del elemento a insertar
     * @param data Dato a colocar en la lista
     * @return true si el indice era válido, false de lo contrario
     */
    boolean setAt(int index, T data);

    T getAt(int index);

    void removeAllWithValue(T data);

    int getSize();

    Iterator<T> getIterator();
}
