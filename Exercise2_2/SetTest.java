/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise2_2;

import java.util.Set;

/**
 *
 * @author alex
 */
public class SetTest 
{
    public static void main(String[] args) 
    {
        Set<String> fruit = new LinkedSortedSet<>();
        
        fruit.add("Strawberry");       
        fruit.add("Apple");
        fruit.add("Banana");
        fruit.add("Berry");
        fruit.add("Watermelon");
        fruit.add("Aatermelon");
        fruit.add("Yatermelon");
        fruit.add("Zatermelon");
        fruit.add("Eatermelon");
        
        System.out.println(fruit);
    }
}
