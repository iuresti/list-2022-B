package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

// Node es una inner class de LinkedList (clase anidada)
// LinkedListIterator es una inner class de LinkedList

// LinkedList es la outer class de Node
// LinkedList es la outer class de LinkedListIterator

public class LinkedList implements List {
    private Node head;
    private Node tail;
    private int size;

    // uaslp.objetos.list.linkedlist.LinkedList.Node

    private static class Node { //Sin palabra de modificador de acceso es package-private
        Node next;
        Node previous;
        Object data;

        public Node(Object data) {
            this.data = data;
        }
    }

    public class LinkedListIterator implements Iterator {
        private Node current;

        public LinkedListIterator() {
            this.current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Object next() {
            Object data = current.data;

            current = current.next;

            return data;
        }
    }


    public void addAtTail(Object data) {
        Node node = new Node(data);

        node.previous = tail;
        tail = node;

        if (head == null) {
            head = node;
        } else {
            node.previous.next = node;
        }

        size++;
    }

    public void addAtFront(Object data) {
        Node node = new Node(data);

        node.next = head;
        head = node;

        if (tail == null) {
            tail = node;
        } else {
            node.next.previous = node;
        }

        size++;
    }

    public boolean remove(int indexToRemove) {

        if (indexToRemove < 0 || indexToRemove >= size) {
            return false;
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else if (indexToRemove == 0) {
            head = head.next;
            head.previous = null;
        } else if (indexToRemove == size - 1) {
            tail = tail.previous;
            tail.next = null;
        } else {
            Node iteratorNode = findNodeByIndex(indexToRemove);

            iteratorNode.previous.next = iteratorNode.next;
            iteratorNode.next.previous = iteratorNode.previous;
        }

        size--;

        return true;
    }

    public void removeAll() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean setAt(int index, Object data) {
        if (index < 0 || index >= size) {
            return false;
        }

        Node node = findNodeByIndex(index);

        node.data = data;

        return true;
    }

    public Object getAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node node = findNodeByIndex(index);

        return node.data;
    }

    public void removeAllWithValue(Object value) {
        Node current = head;

        while (current != null) {
            if (current.data.equals(value)) {
                if (current == head) {
                    head = current.next;
                    if (head == null) {
                        tail = null;
                    } else {
                        head.previous = null;
                    }
                } else {
                    current.previous.next = current.next;
                    if (current == tail) {
                        tail = current.previous;
                    } else {
                        current.next.previous = current.previous;
                    }
                }
            }
            current = current.next;
        }

    }

    public int getSize() {
        return size;
    }

    public LinkedListIterator getIterator() {
        return new LinkedListIterator();
    }

    private Node findNodeByIndex(int index) {
        Node iteratorNode = head;
        int indexIteratorNode = 0;

        while (indexIteratorNode < index) {
            iteratorNode = iteratorNode.next;
            indexIteratorNode++;
        }

        return iteratorNode;
    }


}
