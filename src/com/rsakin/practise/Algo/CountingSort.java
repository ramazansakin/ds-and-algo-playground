package com.rsakin.practise.Algo;

// Counting sort in Java

import java.util.Arrays;

public class CountingSort {

    void countSort(int[] array, int size) {
        // Find the largest element of the array
        int max = Arrays.stream(array).max().getAsInt(), k = 0;

        // Store the count of each element
        int[] count = new int[max + 1];
        for (int i = 0; i < size; i++) count[array[i]]++;

        // Copy the sorted elements into original array
        for (int i = 0; i < max + 1; i++) {
            if (count[i] != 0)
                for (int j = 0; j < count[i]; j++) array[k++] = i;
        }
    }

    // Driver code
    public static void main(String[] args) {

        int[] data = {4, 2, 2, 8, 3, 3, 1, 12412, 5};
        int size = data.length;
        CountingSort cs = new CountingSort();
        cs.countSort(data, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }

    void countSort2(int array[], int size) {
        int[] output = new int[size + 1];

        // Find the largest element of the array
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        // Initialize count array with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[array[i]]++;
        }

        // Store the cumulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted elements into original array
        if (size >= 0) System.arraycopy(output, 0, array, 0, size);
    }

}
