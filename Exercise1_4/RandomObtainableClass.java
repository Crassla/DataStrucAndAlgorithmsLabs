/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise1_4;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 *
 * @author alex
 * @param <E>
 */
public class RandomObtainableClass<E> extends ArrayList<E> implements RandomObtainable<E>
{
    private final Random random;

    public RandomObtainableClass() 
    {
        super();
        this.random = new Random(); 
    }

    @Override
    public E getRandom() throws NoSuchElementException 
    {
        return this.get(random.nextInt(this.size())); 
    }

    @Override
    public boolean removeRandom() throws UnsupportedOperationException 
    {
        boolean hasBeenRemoved;

        if (this.isEmpty())
        {
            hasBeenRemoved = false;
        } 
        
        else 
        {
            this.remove(random.nextInt(this.size()));
            hasBeenRemoved = true;
        }

        return hasBeenRemoved; 
    }  
}
