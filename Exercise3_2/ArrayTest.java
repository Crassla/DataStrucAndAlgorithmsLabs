/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise3_2;

/**
 *
 * @author alex
 */
public class ArrayTest
{
    public static void main(String[] args)
    {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);
        
        System.out.println(queue);
        
        System.out.println(queue.dequeue());
        
        System.out.println(queue);
    }
}
