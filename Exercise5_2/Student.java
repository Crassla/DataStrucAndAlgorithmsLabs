/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise5_2;

/**
 *
 * @author alex
 */
public class Student {

    private int studentID;
    private String name;
    private String address;
    private String birthDate;

    public Student(int studentID, String name, String address, String birthDate) {
        this.studentID = studentID;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }
    
    public int getID() {
        return this.studentID;
    }

    @Override
    public String toString() {
        String output = "";
        
        output += "ID: " + this.studentID;
        output += " Name: " + this.name;
        output += " Address: " + this.address;
        output += " BirthDay: " + this.birthDate;
        
        return output;
    }
}
