/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author alex
 */
public class DocumentReader
{

    public static void main(String[] args) throws FileNotFoundException
    {
        SelfOrganizingArrayList<String> list = new SelfOrganizingArrayList<>();

        System.out.println("Basic List from File: ");
        list = readFile(list);
        System.out.println(list + "\n");

        System.out.println("Adding an Element: ");
        list.add("cat");
        System.out.println(list);

        System.out.println("Accessing Element to Increment Counter: ");
        list.indexOf("cat");
        System.out.println(list);
        list.indexOf("cat");
        System.out.println(list);
        list.indexOf("cat");
        System.out.println(list);
        list.indexOf("cat");
        System.out.println(list + "\n");

        System.out.println("Removing Added Element: ");
        System.out.println(list.remove("cat"));
        System.out.println(list + "\n");

        System.out.println("Iterating through List with Iterators");
        System.out.println("Iterator 1");
        Iterator<String> iterator = list.iterator();
        System.out.print("[");
        while (iterator.hasNext() == true)
        {
            System.out.print(iterator.next() + ((iterator.hasNext() == true) ? ", " : ""));
        }
        System.out.println("]\n");
        System.out.println("Iterator 2");
        Iterator<String> iterator2 = list.listIterator();
        System.out.print("[");
        while (iterator2.hasNext() == true)
        {
            System.out.print(iterator2.next() + ((iterator2.hasNext() == true) ? ", " : ""));
        }
        System.out.println("]\n");
    }

    public static SelfOrganizingArrayList<String> readFile(SelfOrganizingArrayList<String> list) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("./resources/file.txt"));

        while (sc.hasNext())
        {
            String s = sc.next();
            s.toLowerCase();

            if (list.contains(s) == false)
            {
                list.add(s);
            }
        }

        return list;
    }
}
