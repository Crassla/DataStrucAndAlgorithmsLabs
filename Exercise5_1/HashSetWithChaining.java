/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise5_1;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author alex
 */
public class HashSetWithChaining<E> implements Set<E> {

    private int INITIAL_CAPACITY = 5;
    private int numElements;
    private int size;
    private Node<E>[] hashTable;

    public HashSetWithChaining() {
        this.numElements = 0;
        this.size = 0;
        this.hashTable = new Node[INITIAL_CAPACITY];
    }

    @Override
    public boolean add(E e) {
        int index = e.hashCode();

        index = index % INITIAL_CAPACITY;

        if (hashTable[index] != null) {
            Node temp = hashTable[index];
            hashTable[index] = new Node(e);
            hashTable[index].linkNode(temp);
            numElements++;
            return true;
        } else {

            if (size + 1 >= (int) (double) INITIAL_CAPACITY * 0.75) {
                expandCapacity();
            }
            hashTable[index] = new Node(e);
            numElements++;
            size++;

            return true;
        }
    }

    @Override
    public boolean remove(Object o) {

        int index = o.hashCode() % INITIAL_CAPACITY;

        if (hashTable[index] == null) {
            return false;
        } else {
            Node node = hashTable[index];

            if (node.getElement().equals(o)) {
                if (node.hasNext()) {
                    hashTable[index] = node.getNextNode();
                } else {
                    hashTable[index] = null;
                }
                numElements--;
                size--;
                return true;
            } else if (node.hasNext()) {
                Node current = node;
                Node previous = node;
                while (current.hasNext()) {
                    if (current.getElement().equals(o)) {
                        if (current.hasNext()) {
                            previous.linkNode(current.getNextNode());
                        } else {
                            previous.linkNode(null);
                        }
                        numElements--;
                        return true;
                    }
                    previous = current;
                    current = current.getNextNode();
                }

                if (current != null && current.getElement().equals(o)) {
                    if (current.hasNext()) {
                        previous.linkNode(current.getNextNode());
                    } else {
                        previous.linkNode(null);
                    }
                    numElements--;
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int size() {
        return this.numElements;
    }

    @Override
    public boolean isEmpty() {
        return this.numElements == 0;
    }

    @Override
    public boolean contains(Object o) {
        int index = o.hashCode() % INITIAL_CAPACITY;

        if (hashTable[index] == null) {
            return false;
        } else {
            Node node = hashTable[index];
            if (node.getElement().equals(o)) {
                return true;
            } else if (node.hasNext()) {
                Node current = node;
                while (current.hasNext()) {
                    current = current.getNextNode();
                    System.out.println(current.getElement());
                    if (current.getElement().equals(o)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[numElements];
        int count = 0;

        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            if (hashTable[i] != null) {
                Node node = hashTable[i];
                System.out.println("Adding: " + node.getElement());
                arr[count] = node.getElement();
                count++;

                if (node.hasNext()) {
                    Node current = node;

                    while (current.hasNext()) {
                        current = current.getNextNode();
                        System.out.println("Adding: " + current.getElement());
                        arr[count] = current.getElement();
                        count++;
                    }
                }
            }
        }

        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < numElements) {
            T[] arr = (T[]) (new Object[numElements]);
            int count = 0;

            for (int i = 0; i < INITIAL_CAPACITY; i++) {
                if (hashTable[i] != null) {
                    Node node = hashTable[i];
                    System.out.println("Adding: " + node.getElement());
                    arr[count] = (T) node.getElement();
                    count++;

                    if (node.hasNext()) {
                        Node current = node;

                        while (current.hasNext()) {
                            current = current.getNextNode();
                            System.out.println("Adding: " + current.getElement());
                            arr[count] = (T) current.getElement();
                            count++;
                        }
                    }
                }
            }

            return arr;
        } else {
            int count = 0;

            for (int i = 0; i < a.length; i++) {
                if (i < INITIAL_CAPACITY) {
                    if (hashTable[i] != null) {
                        Node node = hashTable[i];
                        System.out.println("Adding: " + node.getElement());
                        a[count] = (T) node.getElement();
                        count++;

                        if (node.hasNext()) {
                            Node current = node;

                            while (current.hasNext()) {
                                current = current.getNextNode();
                                System.out.println("Adding: " + current.getElement());
                                a[count] = (T) current.getElement();
                                count++;
                            }
                        }
                    }
                } else {
                    a[i] = null;
                }
            }
        }

        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        E[] tempArray = (E[]) c.toArray();
        System.out.println(c.size());

        for (int i = 0; i < c.size(); i++) {
            if (!contains(tempArray[i])) {
                System.out.println(tempArray[i]);
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void expandCapacity() {

        System.out.println("\nEXPANDING CAPACITY\n");
        Node[] newArray = new Node[INITIAL_CAPACITY * 2];

        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            if (hashTable[i] != null) {
                Node node = hashTable[i];
                int index = node.getElement().hashCode();
                index = index % INITIAL_CAPACITY * 2;

                if (newArray[index] != null) {
                    newArray[index] = node;
                } else {
                    Node temp = newArray[index];
                    newArray[index] = node;
                    node.linkNode(temp);
                }

                Node current = node;

                while (current.hasNext()) {
                    index = current.getElement().hashCode();
                    index = index % INITIAL_CAPACITY * 2;
                    if (newArray[index] != null) {
                        newArray[index] = current;
                    } else {
                        Node temp = newArray[index];
                        newArray[index] = current;
                        current.linkNode(temp);
                    }

                    current = current.getNextNode();
                }
            }
        }

        INITIAL_CAPACITY = INITIAL_CAPACITY * 2;
        hashTable = newArray;
    }

    @Override
    public String toString() {
        String output = "";

        for (int i = 0; i < INITIAL_CAPACITY; i++) {

            if (hashTable[i] == null) {
                output += i + ": null";
            } else {
                output += i + ": " + hashTable[i];
            }

            output += "\n";
        }

        return output;
    }

    private class Node<E> {

        private E element;
        private Node nextNode;

        public Node(E element) {
            this.element = element;
        }

        public void linkNode(Node node) {
            this.nextNode = node;
        }

        public E getElement() {
            return this.element;
        }

        public boolean hasNext() {
            return !(nextNode == null);
        }

        public Node getNextNode() {
            return this.nextNode;
        }

        @Override
        public String toString() {
            String output = "";

            output += this.element;

            if (nextNode != null) {
                output += " ----> " + nextNode;
            }

            return output;
        }
    }
}
