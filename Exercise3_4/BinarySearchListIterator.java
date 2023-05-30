/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise3_4;

import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author alex
 */
public class BinarySearchListIterator<E extends Comparable>
{
    private final List<E> elements;
    
    public BinarySearchListIterator(List<E> elements)
    {
        this.elements = elements;
    }
    
    public int search(E target)
    {
        if (target == null)
            throw new NullPointerException("target is null");
        ListIterator<E> iterator = elements.listIterator();
        
        return search(target, 0, elements.size(), iterator);
    }
    
    private int search(E target, int start, int end, ListIterator<E> iterator)
    {
        if (start >= end)
            return -start-1;
        else
        {
            int midpoint = (start + end) / 2;
            int i = 0;
            int comparison = 0;
            boolean found = false;
            
            while (!found && iterator.hasNext())
            {
                if (i == midpoint)
                {
                    E e = iterator.next();
                    System.out.println(e);
                    comparison = target.compareTo(e);
                    found = true;
                }
                else
                {
                    iterator.next();
                    i++;
                }
            }
            
            ListIterator<E> newiterator = elements.listIterator();
            
            if (comparison == 0)
                return midpoint;
            else if (comparison < 0)
                return search(target, start, midpoint, newiterator);
            else
                return search(target, midpoint + 1, end, newiterator);
        }
    }
    
    @Override
    public String toString()
    {
        String output = "[";
        int i = 0;
        
        for (E e : elements)
        {
            output += (e + ((i == elements.size() - 1) ? "" : ", "));
            i++;
        }
        
        output += "]";
        
        return output;
    }
}
