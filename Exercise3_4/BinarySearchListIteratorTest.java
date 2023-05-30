/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise3_4;

import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class BinarySearchListIteratorTest
{
    public static void main(String[] args)
    {     
        ArrayList<String> list = new ArrayList<>();
        
        list.add("ant");
        list.add("bat");
        list.add("cat");
        list.add("cow");
        list.add("dog");
        list.add("eel");
        list.add("fly");
        list.add("fox");
        list.add("owl");
        list.add("pig");
        list.add("rat");
        
        BinarySearchListIterator testList = new BinarySearchListIterator(list);
        System.out.println(testList);
        String target = "ant";
        
        int index = testList.search(target);
        
        if (index >= 0)
            System.out.println(target + " found at index " + index);
        else
        {
            System.out.println(target + " not at index " + (-index-1));
            list.add((-index-1), target);
        }
        
        System.out.println(list);
    }
}
