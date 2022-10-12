package uaslp.objetos.list;

public interface List {
    void addAtTail(String data);

    void addAtFront(String data);

    boolean remove(int index);

    void removeAll();

    /**
     * Permite colocar un elemento en un índice específico de la lista.
     *
     * @param index Indice del elemento a insertar
     * @param data Dato a colocar en la lista
     * @return true si el indice era válido, false de lo contrario
     */
    boolean setAt(int index, String data);

    String getAt(int index);

    void removeAllWithValue(String data);

    int getSize();

    Iterator getIterator();
}
