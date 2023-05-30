/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise5_1;

/**
 *
 * @author alex
 */
public class Student {

    private int studentID;
    private String name;
    private String address;
    private String birthDate;
    private final double PRIME = 113;
    private final double MODULUS = 263;

    public Student(int studentID, String name, String address, String birthDate) {
        this.studentID = studentID;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        int code = 0;

        for (int i = 0; i < name.length(); i++) {
            double pow = (name.length() - 1) - i;
            code += name.charAt(i) * (int) Math.pow(PRIME, pow);
        }

        code = (int) ((double) code % MODULUS);
        
        if (code < 0) {
            code = Math.abs(code);
        }

        return code;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
