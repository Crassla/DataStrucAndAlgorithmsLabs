/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise4_4;

import java.util.NoSuchElementException;

/**
 *
 * @author alex
 */
public class PriorityQueue implements QueueADT<Task<?>> {

    private final HeapADT<Task<?>> heap;

    public PriorityQueue() {
        heap = new ArrayHeap<>();
    }

    @Override
    public void enqueue(Task<?> element) {
        heap.add(element);
    }

    @Override
    public Task<?> dequeue() {
        return heap.removeMin();
    }

    @Override
    public Task<?> first() {
        Task<?> returnHeap = heap.removeMin();

        heap.add(returnHeap);

        return returnHeap;
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }

    public static void main(String[] args) {
        Task<String> task1 = new Task<>("Do DSA", 1);
        Task<String> task2 = new Task<>("Eat", 3);
        Task<String> task3 = new Task<>("Drink", 2);
        Task<String> task4 = new Task<>("Have a Life", 10);
        
        PriorityQueue queue = new PriorityQueue();
        
        queue.enqueue(task1);
        queue.enqueue(task2);
        queue.enqueue(task3);
        queue.enqueue(task4);
        
        System.out.println(queue.first());
        
        while (!queue.isEmpty())
        {
            System.out.println(queue.dequeue());
        }
        
        System.out.println(queue.isEmpty());
    }
}
