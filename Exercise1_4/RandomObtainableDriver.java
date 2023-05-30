/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise1_4;

/**
 *
 * @author alex
 */
public class RandomObtainableDriver 
{
    public static void main(String[] args) 
    {
        RandomObtainableClass<Integer> testList1 = new RandomObtainableClass<>();
        
        testList1.add(0);
        testList1.add(1);
        testList1.add(2);
        testList1.add(3);
        
        RandomObtainableClass<String> testList2 = new RandomObtainableClass<>();
        
        testList2.add("Hello");
        testList2.add("World");
        testList2.add("This");
        testList2.add("Works");
        
        System.out.println(testList1.getRandom());
        System.out.println(testList2.getRandom());
        
        for (Integer x : testList1)
        {
            System.out.println(x);
        }
        
        for (String x : testList2)
        {
            System.out.println(x);
        }
        
        testList1.removeRandom();
        testList2.removeRandom();
        
        for (Integer x : testList1)
        {
            System.out.println(x);
        }
        
        for (String x : testList2)
        {
            System.out.println(x);
        }
        
        RandomObtainableClass<Character> testList3 = new RandomObtainableClass<>();
        
        testList3.add('c');
        
        System.out.println(testList3.removeRandom());
        System.out.println(testList3.removeRandom());
    }
}
