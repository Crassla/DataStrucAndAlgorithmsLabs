/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise3_5;

import java.util.Random;

/**
 * A class which includes common algorithms for sorting arrays of Comparable
 * objects in place. Note the elements of the array are presumed to be non-null
 */
public class ArraySorter<E extends Comparable>
{

    public static int COMPARE_COUNTER = 0;
    public static int SWAP_COUNTER = 0;

    public void selectionSort(E[] list)
    {
        COMPARE_COUNTER = 0;
        SWAP_COUNTER = 0;
        int indexMin; // index of least element
        E temp; // temporary reference to an element for swapping
        for (int i = 0; i < list.length - 1; i++)
        {  // find the least element that has index>=i
            indexMin = i;
            for (int j = i + 1; j < list.length; j++)
            {
                if (list[j].compareTo(list[indexMin]) < 0)
                {
                    indexMin = j;
                }
                COMPARE_COUNTER++;
            }
            // swap the element at indexMin with the element at i
            temp = list[indexMin];
            list[indexMin] = list[i];
            list[i] = temp;
            SWAP_COUNTER++;
        }
    }

    public void insertionSort(E[] list)
    {
        COMPARE_COUNTER = 0;
        SWAP_COUNTER = 0;
        E elementInsert;
        for (int i = 1; i < list.length; i++)
        {
            // get the element at index i to insert at some index<=i
            elementInsert = list[i];
            // find index where to insert element to maintain 0..i sorted
            int indexInsert = i;
            while (indexInsert > 0
                    && list[indexInsert - 1].compareTo(elementInsert) > 0)
            {  // shift element at insertIndex-1 along one to make space
                list[indexInsert] = list[indexInsert - 1];
                indexInsert--;
                COMPARE_COUNTER++;
            }
            // insert the element
            list[indexInsert] = elementInsert;
            SWAP_COUNTER++;
        }
    }

    public void bubbleSort(E[] list)
    {
        COMPARE_COUNTER = 0;
        SWAP_COUNTER = 0;
        E temp; // temporary reference to an element for swapping
        for (int i = list.length - 1; i >= 0; i--)
        {  // pass through indices 0..i and bubble (swap) adjacent
            // elements if out of order
            for (int j = 0; j < i; j++)
            {
                if (list[j].compareTo(list[j + 1]) > 0)
                {  // swap the elements at indices j and j+1
                    temp = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = temp;
                    SWAP_COUNTER++;
                }
                COMPARE_COUNTER++;
            }
        }
    }

    public void quickSort(E[] list)
    {
        COMPARE_COUNTER = 0;
        SWAP_COUNTER = 0;
        quickSortSegment(list, 0, list.length);
    }

    // recursive method which applies quick sort to the portion
    // of the array between start (inclusive) and end (exclusive)
    private void quickSortSegment(E[] list, int start, int end)
    {
        if (end - start > 1) // then more than one element to sort
        {  // partition the segment into two segments
            int indexPartition = partition(list, start, end);
            // sort the segment to the left of the partition element
            quickSortSegment(list, start, indexPartition);
            // sort the segment to the right of the partition element
            quickSortSegment(list, indexPartition + 1, end);
        }
    }

    // use the index start to partition the segment of the list
    // with the element at start as the partition element
    // separating the list segment into two parts, one less than
    // the partition, the other greater than the partition
    // returns the index where the partition element ends up
    private int partition(E[] list, int start, int end)
    {
        E temp; // temporary reference to an element for swapping
        E partitionElement = list[start];
        int leftIndex = start; // start at the left end
        int rightIndex = end - 1; // start at the right end
        // swap elements so elements at left part are less than
        // partition element and at right part are greater
        while (leftIndex < rightIndex)
        {  // find element starting from left greater than partition
            COMPARE_COUNTER++;
            while (list[leftIndex].compareTo(partitionElement) <= 0
                    && leftIndex < rightIndex)
            {
                leftIndex++; // this index is on correct side of partition
            }         // find element starting from right less than partition
            COMPARE_COUNTER++;
            while (list[rightIndex].compareTo(partitionElement) > 0)
            {
                rightIndex--; // this index is on correct side of partition
            }
            if (leftIndex < rightIndex)
            {  // swap these two elements
                temp = list[leftIndex];
                list[leftIndex] = list[rightIndex];
                list[rightIndex] = temp;
                SWAP_COUNTER++;
            }
        }
        // put the partition element between the two parts at rightIndex
        list[start] = list[rightIndex];
        list[rightIndex] = partitionElement;
        return rightIndex;
    }

    public void mergeSort(E[] list)
    {
        COMPARE_COUNTER = 0;
        SWAP_COUNTER = 0;
        mergeSortSegment(list, 0, list.length);
    }

    // recursive method which applies merge sort to the portion
    // of the array between start (inclusive) and end (exclusive)
    private void mergeSortSegment(E[] list, int start, int end)
    {
        int numElements = end - start;
        if (numElements > 1)
        {
            int middle = (start + end) / 2;
            // sort the part to the left of middle
            SWAP_COUNTER++;
            mergeSortSegment(list, start, middle);
            // sort the part to the right of middle
            SWAP_COUNTER++;
            mergeSortSegment(list, middle, end);
            // copy the two parts elements into a temporary array
            E[] tempList = (E[]) (new Comparable[numElements]); //unchecked
            for (int i = 0; i < numElements; i++)
            {
                tempList[i] = list[start + i];
            }
            // merge the two sorted parts from tempList back into list
            int indexLeft = 0; // current index of left part
            int indexRight = middle - start; // current index of right part
            for (int i = 0; i < numElements; i++)
            {  // determine which element to next put in list
                if (indexLeft < (middle - start))//left part still has elements
                {
                    if (indexRight < (end - start))// right part also has elem
                    {
                        COMPARE_COUNTER++;
                        if (tempList[indexLeft].compareTo(tempList[indexRight]) < 0) // left element smaller 
                        {
                            list[start + i] = tempList[indexLeft++];
                        }
                        else // right element smaller
                        {
                            list[start + i] = tempList[indexRight++];
                        }
                    }
                    else // take element from left part
                    {
                        list[start + i] = tempList[indexLeft++];
                    }
                }
                else // take element from right part
                {
                    list[start + i] = tempList[indexRight++];
                }
            }
        }
    }

    // driver main method to test one of the algorithms
    public static void main(String[] args)
    {
        ArraySorter<Integer> sorter = new ArraySorter();
        Random generator = new Random();

        Integer[] list = new Integer[100000];

        for (int i = 0; i < list.length; i++)
        {
            list[i] = generator.nextInt(100);
        }

        Integer[] listToSort = new Integer[list.length];

        System.out.println("=====================SORTING ALGORITHUMS=====================\n\n");
        System.out.println("========================SELECTION SORT========================\n");

        System.arraycopy(list, 0, listToSort, 0, list.length);
        long startTime = System.nanoTime();
        sorter.selectionSort(listToSort);
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000;

        System.out.println("TIME TAKEN: " + totalTime + "MS");
        System.out.println("COMPARES MADE: " + COMPARE_COUNTER);
        System.out.println("SWAPS MADE: " + SWAP_COUNTER);

        System.out.println("=========================BUBBLE SORT==========================\n");

        System.arraycopy(list, 0, listToSort, 0, list.length);
        startTime = System.nanoTime();
        sorter.bubbleSort(listToSort);
        endTime = System.nanoTime();
        totalTime = (endTime - startTime) / 1000000;

        System.out.println("TIME TAKEN: " + totalTime + "MS");
        System.out.println("COMPARES MADE: " + COMPARE_COUNTER);
        System.out.println("SWAPS MADE: " + SWAP_COUNTER);

        System.out.println("=======================INSERTION SORT=========================\n");

        System.arraycopy(list, 0, listToSort, 0, list.length);
        startTime = System.nanoTime();
        sorter.insertionSort(listToSort);
        endTime = System.nanoTime();
        totalTime = (endTime - startTime) / 1000000;

        System.out.println("TIME TAKEN: " + totalTime + "MS");
        System.out.println("COMPARES MADE: " + COMPARE_COUNTER);
        System.out.println("SWAPS MADE: " + SWAP_COUNTER);

        System.out.println("=========================QUICK SORT===========================\n");

        System.arraycopy(list, 0, listToSort, 0, list.length);
        startTime = System.nanoTime();
        sorter.quickSort(listToSort);
        endTime = System.nanoTime();
        totalTime = (endTime - startTime) / 1000000;

        System.out.println("TIME TAKEN: " + totalTime + "MS");
        System.out.println("COMPARES MADE: " + COMPARE_COUNTER);
        System.out.println("SWAPS MADE: " + SWAP_COUNTER);

        System.out.println("=========================MERGE SORT===========================\n");

        System.arraycopy(list, 0, listToSort, 0, list.length);
        startTime = System.nanoTime();
        sorter.mergeSort(listToSort);
        endTime = System.nanoTime();
        totalTime = (endTime - startTime) / 1000000;

        System.out.println("TIME TAKEN: " + totalTime + "MS");
        System.out.println("COMPARES MADE: " + COMPARE_COUNTER);
        System.out.println("SWAPS MADE: " + SWAP_COUNTER);
    }
}
