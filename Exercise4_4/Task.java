/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise4_4;

/**
 *
 * @author alex
 */
public class Task<E extends Comparable> implements Comparable<Task> {

    private E task;
    private int priority;
    
    public Task(E task, int priority)
    {
        this.task = task;
        this.priority = priority;
    }
    
    @Override
    public int compareTo(Task o) {      
        if (o.priority == priority){
            return 0;
        }
        
        return (priority - o.priority);
    }
    
    @Override 
    public String toString()
    {
        return "TASK>> [" + task + "] PRIORITY: " + priority;
    }

}
