/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise1_4;

import java.util.NoSuchElementException;

/**
 *
 * @author alex
 * @param <E>
 */
public interface RandomObtainable<E>
{
    public E getRandom() throws NoSuchElementException;
    public boolean removeRandom() throws UnsupportedOperationException;
}
