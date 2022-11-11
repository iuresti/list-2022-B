package uaslp.objetos.list;

import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public interface List<T> {

    /**
     * No acepta nulos
     *
     * @param data Object to be inserted in the list
     */
    void addAtTail(T data) throws NullNotAllowedException;

    void addAtFront(T data) throws NullNotAllowedException;

    void remove(int index) throws WrongIndexException;

    void removeAll();

    /**
     * Permite colocar un elemento en un índice específico de la lista.
     *
     * @param index Indice del elemento a insertar
     * @param data  Dato a colocar en la lista
     */
    void setAt(int index, T data) throws WrongIndexException, NullNotAllowedException;

    T getAt(int index) throws WrongIndexException;

    void removeAllWithValue(T data);

    int getSize();

    Iterator<T> getIterator();
}
