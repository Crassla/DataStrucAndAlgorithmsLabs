/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise3_3;

import java.util.NoSuchElementException;

/**
 *
 * @author alex
 */
public class ArrayQueue<E>
{

    private int capacity = 10;
    protected int front;
    protected int rear;
    protected E[] elements;

    public ArrayQueue()
    {
        front = 0;
        rear = 0;
        elements = (E[]) (new Object[capacity]); // unchecked
    }

    public void enqueue(E element)
    {
        if (front == rear)//case if queue is completely full
        {
            expandCapacity();
        }
        else
        {
            if (front == 0 && rear == capacity - 1)
            {
                expandCapacity();
            }
            else
            {
                if (rear == capacity - 1 && front != 0)
                {
                    rear = 0;
                }
                else
                {
                    if (front == capacity - 1 && rear != 0)
                    {
                        front = 0;
                    }
                }
            }
        }

        elements[rear] = element;

        rear++;
    }

    public E dequeue() throws NoSuchElementException
    {
        if (front != rear)
        {
            E output = elements[front];

            elements[front] = null;

            front++;

            return output;
        }
        else
        {
            throw new NoSuchElementException();
        }
    }

    public E first() throws NoSuchElementException
    {
        if (front != rear)
        {
            return this.elements[front];
        }
        else
        {
            throw new NoSuchElementException();
        }
    }

    public boolean isEmpty()
    {
        return this.front == this.rear;
    }

    public int size()
    {
        return rear - front;
    }

    @Override
    public String toString()
    {
        String output = "[";

        if (rear >= front)  //checks if the array has looped 
        {
            for (int i = front; i < rear; i++)
            {
                output += elements[i];

                if (i < rear - 1)
                {
                    output += ", ";
                }
            }
        }
        else
        {
            for (int i = front; i < capacity; i++)
            {
                output += elements[i] + ", ";
            }

            for (int i = 0; i < rear; i++)
            {
                output += elements[i];

                if (i < rear - 1)
                {
                    output += ", ";
                }
            }
        }

        output += "]";

        return output;
    }

    private void expandCapacity()
    {
        capacity = elements.length * 2;
        E[] largerArray = (E[]) (new Object[elements.length * 2]);//unchecked
        // copy the elements array to the largerArray

        if (rear >= front) //checks if the array loops back around
        {
            for (int i = front; i < rear; i++)
            {
                largerArray[i] = elements[i];
            }
        }
        else
        {
            int j = 0;

            for (int i = front; i < capacity; i++)
            {
                largerArray[j] = elements[i];
                j++;
            }

            for (int i = 0; i < rear; i++)
            {
                largerArray[j] = elements[i];
                j++;
            }
        }

        elements = largerArray;
    }
}
