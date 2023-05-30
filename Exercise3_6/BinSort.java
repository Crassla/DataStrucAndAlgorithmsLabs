/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise3_6;

import java.util.Random;

/**
 *
 * @author alex
 */
public class BinSort
{

    public static void binSort(int[] list, int MAX_VALUE)
    {
        int flags[] = new int[MAX_VALUE + 1];

        for (int i = 0; i < list.length; i++)
        {
            flags[list[i]]++;
        }

        int flagNo = 0;
        int index = 0;
        
        while (index < list.length)
        {
            if (flags[flagNo] == 0)
            {
                flagNo++;
            }
            else
            {
                for (int j = 0; j < flags[flagNo]; j++)
                {
                    list[index] = flagNo;
                    index++;
                }
                
                flagNo++;
            }
        }
    }

    public static void main(String[] args)
    {
        Random generator = new Random();
        final int MAX_NUM = 100;

        int[] list = new int[MAX_NUM];

        for (int i = 0; i < list.length; i++)
        {
            list[i] = generator.nextInt(MAX_NUM);
        }

        System.out.println("=====================SORTING ALGORITHUMS=====================\n\n");
        System.out.println("========================BIN SORT========================\n");

        System.out.println("Array to sort: ");

        System.out.print("[");
        for (int i = 0; i < list.length; i++)
        {
            System.out.print(list[i] + ((i == list.length - 1) ? "" : ", "));
        }
        System.out.print("]\n\n");

        long startTime = System.nanoTime();
        binSort(list, MAX_NUM);
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000;

        System.out.print("[");
        for (int i = 0; i < list.length; i++)
        {
            System.out.print(list[i] + ((i == list.length - 1) ? "" : ", "));
        }
        System.out.print("]\n\n");

        System.out.println("TIME TAKEN: " + totalTime + " microS");

    }
}
