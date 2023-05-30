/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise2_2;

/**
 *
 * @author alex
 */
public class LinkedSortedSet<E extends Comparable<E>> extends LinkedSet<E> 
{

    public boolean add(E o) 
    {
        if (!(contains(o))) 
        {
            Node<E> newNode = new Node<E>(o);
            if (numElements == 0) 
            {
                firstNode = newNode;
                numElements++;
                return true;
            } 
            else 
            {
                Node<E> previous = firstNode;
                Node<E> current = firstNode.next;
                
                if (current == null && numElements == 1)
                {
                    if (firstNode.element.compareTo(newNode.element) > 0)
                    {
                        newNode.next = firstNode;
                        firstNode = newNode;
                        numElements++;
                        return true;
                    }
                    else
                    {
                        firstNode.next = newNode;
                        numElements++;
                        return true;
                    }
                }
                
                while (current != null)
                {
                    if (firstNode.element.compareTo(newNode.element) > 0)
                    {
                        newNode.next = firstNode;
                        firstNode = newNode;
                        numElements++;
                        return true;
                    }
                    if (current.element.compareTo(newNode.element) > 0)
                    {
                        newNode.next = current;
                        previous.next = newNode;
                        numElements++;
                        return true;
                    }
                    else
                    {
                        previous = current;
                        current = current.next;
                    }
                }
                
                previous.next = newNode;
                numElements++;
                return true;
            }
        }       
        else 
        {
            return false;
        }
    } 
}