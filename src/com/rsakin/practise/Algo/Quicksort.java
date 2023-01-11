package com.rsakin.practise.Algo;

import java.util.Arrays;

// Quick sort in Java
public class Quicksort {

    // method to find the partition position
    private static int partition(int[] array, int low, int high) {

        // choose the rightmost element as pivot, or you can even write a small algorithm to choose a better pivot
        // it's important to make the whole algorithm close to n.log(n)
        int pivot = array[high];
        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high + 1; j++) {
            if (array[j] <= pivot) {
                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;
                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // return the position from where partition is done
        return i;
    }

    static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pi = partition(array, low, high);
            // recursive call on the left of pivot
            quickSort(array, low, pi - 1);
            // recursive call on the right of pivot
            quickSort(array, pi + 1, high);
        }
    }
}

// Main class
class Main {

    public static void main(String args[]) {

        int[] data = {8, 7, 2, 1, 0, 9, 6};
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(data));

        // call quicksort() on array data
        Quicksort.quickSort(data);

        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
