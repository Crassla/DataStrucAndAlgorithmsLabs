/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise5_1;

/**
 *
 * @author alex
 */
public class Driver {

    public static void main(String[] args) {
        HashSetWithChaining<Student> hash = new HashSetWithChaining<>();

        Student jack = new Student(5, "Jack", "temp", "temp");
        Student eek = new Student(2, "Keanna", "temp", "temp");

        hash.add(new Student(1, "Alex", "temp", "temp"));
        hash.add(new Student(2, "Michael", "temp", "temp"));
        hash.add(eek);
        hash.add(jack);
        hash.add(new Student(6, "Nathan", "temp", "temp"));
        hash.add(new Student(7, "Aidan", "temp", "temp"));
        hash.add(new Student(8, "Harrison", "temp", "temp"));

        HashSetWithChaining<Student> hash2 = new HashSetWithChaining<>();
        hash2.add(new Student(1, "Alex", "temp", "temp"));
        hash2.add(eek);
        
        System.out.println(hash2.containsAll(hash));
        
        System.out.println(hash);
    }
}
