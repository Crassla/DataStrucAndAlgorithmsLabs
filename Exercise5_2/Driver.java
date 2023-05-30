/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise5_2;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author alex
 */
public class Driver {

    public static void main(String[] args) {
        HashMap<Integer, Student> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);

        Student s1 = new Student(20104599, "Alex", "1234 fake street", "12/20/22");
        Student s2 = new Student(20104699, "Michael", "1234 fake street", "12/20/22");
        Student s3 = new Student(20104799, "Harrison", "1234 fake street", "12/20/22");
        Student s4 = new Student(20104899, "Keanna", "1234 fake street", "12/20/22");
        Student s5 = new Student(20104999, "Aidan", "1234 fake street", "12/20/22");
        
        map.put(s1.getID(), s1);
        map.put(s2.getID(), s2);
        map.put(s3.getID(), s3);
        map.put(s4.getID(), s4);
        map.put(s5.getID(), s5);
        
        int input = 0;
        
        while (input != 10) {
            System.out.println("\nPlease input StudentID to get student info: ");
            input = scan.nextInt();
            
            if (map.get(input) != null) {
                System.out.println(map.get(input));
            }
            else {
                System.out.println("Student does not exist");
            }
        }
    }
}
