/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question3;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * @author alex
 */
public class SelfOrganizingArrayList<E> implements List<E>
{

    private final int INITIAL_CAPACITY = 20;
    protected int numElements;
    protected Node<E>[] underlyingList;

    public SelfOrganizingArrayList()
    {
        this.underlyingList = new Node[INITIAL_CAPACITY];
        this.numElements = 0;
    }

    public SelfOrganizingArrayList(Collection<? extends E> c)
    {
        this();
        for (E element : c)
        {
            add(element);
        }
    }

    @Override
    public int size()
    {
        return numElements;
    }

    @Override
    public boolean isEmpty()
    {
        return (numElements == 0);
    }

    @Override
    public boolean contains(Object o)
    {
        for (int i = 0; i < numElements; i++)
        {
            if (underlyingList[i].getElement().equals(o))
            {
                underlyingList[i].incrementCounter();
                this.bubble(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new ArrayIterator2(underlyingList, numElements);
    }

    @Override
    public Object[] toArray()
    {
        E[] tempArray = (E[]) (new Object[numElements]);

        for (int i = 0; i < numElements; i++)
        {
            tempArray[i] = underlyingList[i].getElement();
        }

        return tempArray;
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        throw new UnsupportedOperationException("Not supported for this list type");
    }

    @Override
    public boolean add(E e)
    {
        boolean added = false;

        if (numElements >= underlyingList.length)
        {
            expandCapacity();
        }

        underlyingList[numElements++] = new Node<E>(e);
        added = true;

        return added;
    }

    @Override
    public boolean remove(Object o)
    {
        int index = 0;
        boolean found = false;
        for (int i = 0; i < numElements && !found; i++)
        {
            if ((underlyingList[i] == null && o == null) || (underlyingList[i] != null && underlyingList[i].getElement().equals(o)))
            {
                index = i;
                found = true;
            }
        }
        if (found)
        {
            underlyingList[index] = underlyingList[numElements - 1];
            underlyingList[numElements - 1] = null;
            numElements--;
        }
        return found;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        E[] tempArray = (E[]) c.toArray();
        E[] thisArray = (E[]) this.toArray();

        if (c.size() >= this.size())
        {
            for (int i = 0; i < c.size(); i++)
            {
                if (this.contains(tempArray[i]) == false)
                {
                    return false;
                }
            }
        }
        else
        {
            for (int i = 0; i < numElements; i++)
            {
                if (c.contains(thisArray[i]) == false)
                {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        boolean output = false;

        for (E e : c)
        {
            output = this.add(e);
        }

        return output;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        throw new UnsupportedOperationException("Not supported for this list type");
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        if (c == null)
        {
            throw new NullPointerException("list is null");
        }

        boolean output = true;

        E[] tempArray = (E[]) c.toArray();

        for (int i = 0; i < c.size(); i++)
        {
            output = this.remove(tempArray[i]);
        }

        return output;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        if (c == null)
        {
            throw new NullPointerException("list is null");
        }

        boolean output = false;
        boolean repeat = false;

        for (int i = 0; i < numElements; i++)
        {
            if (repeat == true)
            {
                i = 0;
                repeat = false;
            }

            if (c.contains(underlyingList[i].getElement()) == false)
            {
                output = this.remove(underlyingList[i].getElement());
                repeat = true;  //redoing the loop due to remove code removing via adding last element to removed one
            }
        }

        return output;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < numElements; i++)
        {
            underlyingList[i] = null;
        }

        numElements = 0;
    }

    @Override
    public E get(int index)
    {
        if (index < 0 || index > numElements)
        {
            return null;
        }
        else
        {
            underlyingList[index].incrementCounter();
            this.bubble(index);
        }

        return underlyingList[index].getElement();
    }

    @Override
    public E set(int index, E element)
    {
        throw new UnsupportedOperationException("Not supported for this list type");
    }

    @Override
    public void add(int index, E element)
    {
        throw new UnsupportedOperationException("Not supported for this list type");
    }

    @Override
    public E remove(int index)
    {
        if (index < numElements && index >= 0)
        {
            E output = underlyingList[index].getElement();
            underlyingList[index] = underlyingList[numElements - 1];
            underlyingList[numElements - 1] = null;
            numElements--;
            return output;
        }
        else
        {
            return null;
        }
    }

    //returns negative if the object is not found in the list
    @Override
    public int indexOf(Object o)
    {
        for (int i = 0; i < numElements; i++)
        {
            if (underlyingList[i].getElement().equals(o) == true)
            {
                underlyingList[i].incrementCounter();
                this.bubble(i);
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o)
    {
        int output = -1;

        for (int i = 0; i < numElements; i++)
        {
            if (underlyingList[i].getElement().equals(o) == true)
            {
                output = i;
            }
        }

        if (output != -1)
        {
            underlyingList[output].incrementCounter();
            this.bubble(output);
        }

        return output;
    }

    @Override
    public ListIterator<E> listIterator()
    {
        return new ArrayIterator<E>(underlyingList, numElements);
    }

    @Override
    public ListIterator<E> listIterator(int index)
    {
        return new ArrayIterator<E>(underlyingList, numElements, index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex)
    {
        SelfOrganizingArrayList<E> subList = new SelfOrganizingArrayList<>();

        if (fromIndex > toIndex)
        {
            return null;
        }
        if (numElements <= toIndex)
        {
            toIndex = numElements - 1;
        }
        if (fromIndex < 0)
        {
            fromIndex = 0;
        }

        for (int i = fromIndex; i <= toIndex; i++)
        {
            subList.add(underlyingList[i].getElement());
        }

        return subList;
    }

    private void expandCapacity()
    {
        Node<E>[] largerArray = new Node[underlyingList.length * 2];
        for (int i = 0; i < numElements; i++)
        {
            largerArray[i] = underlyingList[i];
        }
        underlyingList = largerArray;
    }

    private void bubble(int index)
    {
        for (int i = index; i >= 0; i--)
        {
            if (i != 0)
            {
                if (underlyingList[i].getCounter() > underlyingList[i - 1].getCounter())
                {
                    Node<E> temp = underlyingList[i - 1];
                    underlyingList[i - 1] = underlyingList[i];
                    underlyingList[i] = temp;
                }
            }
        }
    }

    public String toString()
    {
        String output = "[";

        for (int i = 0; i < numElements; i++)
        {
            output += underlyingList[i] + ((i == numElements - 1) ? "" : ", ");
        }

        return output += "]";
    }

    private class Node<E>
    {

        private E element;
        private int counter;

        public Node(E element)
        {
            this.element = element;
            this.counter = 1;
        }

        public E getElement()
        {
            return element;
        }

        public void incrementCounter()
        {
            counter = counter + 1;
        }

        public int getCounter()
        {
            return this.counter;
        }

        @Override
        public String toString()
        {
            return "" + this.element + "(" + this.counter + ")";
        }
    }

    private class ArrayIterator<E> implements ListIterator<E>
    {

        private int numElements;
        private Node<E>[] elements;
        private int nextIndex;

        public ArrayIterator(Node<E>[] elements, int numElements)
        {
            if (numElements > elements.length)
            {
                numElements = elements.length;
            }
            this.numElements = numElements;
            this.elements = elements;
            nextIndex = 0;
        }

        public ArrayIterator(Node<E>[] elements, int numElements, int index)
        {
            if (numElements > elements.length)
            {
                numElements = elements.length;
            }
            this.numElements = numElements;
            this.elements = elements;
            nextIndex = index;
        }

        @Override
        public boolean hasNext()
        {
            return (nextIndex < numElements);
        }

        @Override
        public E next() throws NoSuchElementException
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }

            return elements[nextIndex++].getElement();
        }

        @Override
        public void remove() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException("Not supported for this list type");
        }

        @Override
        public boolean hasPrevious()
        {
            return nextIndex - 1 < 0;
        }

        @Override
        public E previous() throws NoSuchElementException
        {
            if (!hasPrevious())
            {
                throw new NoSuchElementException();
            }

            return elements[nextIndex - 1].getElement();
        }

        @Override
        public int nextIndex()
        {
            return nextIndex + 1;
        }

        @Override
        public int previousIndex()
        {
            return nextIndex - 1;
        }

        @Override
        public void set(E e)
        {
            throw new UnsupportedOperationException("Not supported for this list type");
        }

        @Override
        public void add(E e)
        {
            throw new UnsupportedOperationException("Not supported for this list type");
        }
    }

    private class ArrayIterator2<E> implements Iterator<E>
    {

        private int numElements;
        private Node<E>[] elements;
        private int nextIndex;

        public ArrayIterator2(Node<E>[] elements, int numElements)
        {
            if (numElements > elements.length)
            {
                numElements = elements.length;
            }
            this.numElements = numElements;
            this.elements = elements;
            nextIndex = 0;
        }

        @Override
        public boolean hasNext()
        {
            return (nextIndex < numElements);
        }

        @Override
        public E next() throws NoSuchElementException
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }

            return elements[nextIndex++].getElement();
        }

        @Override
        public void remove() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException("Not supported for this list type");
        }
    }
}
