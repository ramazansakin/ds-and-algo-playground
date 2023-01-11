package com.rsakin.practise.Algo;

// Merge sort in Java
class MergeSort {

    // Merge two sub-arrays L and M into arr
    private void merge(int[] arr, int p, int q, int r) {
        // Create L ← A[p..q] and M ← A[q+1..r]
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        System.arraycopy(arr, p, leftArr, 0, n1);
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[q + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i = 0, j = 0, k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // helper method to make the
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // Divide the array into two sub-arrays, sort them and merge them
    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // m is the point where the array is divided into two sub-arrays
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            // Merge the sorted sub-arrays
            merge(arr, l, m, r);
        }
    }

    // Print the array
    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    // Driver program to test
    public static void main(String[] args) {
        int[] arr = {6, 5, 12, 10, 9, 1};

        MergeSort ob = new MergeSort();
        ob.mergeSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}