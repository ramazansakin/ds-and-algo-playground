package com.rsakin.practise.Algo;

// Radix Sort in Java Programming

import java.util.Arrays;

class RadixSort {

    // Using counting sort to sort the elements in the basis of significant places
    void countingSort(int[] array, int size, int place) {
        int[] output = new int[size + 1];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }

        if (size > 0) System.arraycopy(output, 0, array, 0, size);
    }

    // Function to get the largest element from an array
    int getMax(int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }

    void radixSort(int[] array, int size) {
        // Get maximum number
        int max = getMax(array);

        // Apply counting sort to sort elements based on place value
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(array, size, place);
    }

    // Driver code
    public static void main(String[] args) {

        int[] data = {123, 121, 432, 3, 564, 23, 8, 1, 45, 5345, 788};
        int size = data.length;
        RadixSort rs = new RadixSort();
        rs.radixSort(data, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }

}