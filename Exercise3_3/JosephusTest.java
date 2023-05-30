/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise3_3;

import java.util.Scanner;

/**
 *
 * @author alex
 */
public class JosephusTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("=====================Josephus Queue=====================");
        System.out.println("Enter the number of Soldiers in the Josephus Problem:");
    
        int soldiers = scan.nextInt();
        
        System.out.println("Enter the number to remove the soldier!!:");
        
        int remNum = scan.nextInt();
        
        JosephusQueue queue = new JosephusQueue(soldiers, remNum);
        queue.josephusProblem();
    }
}
