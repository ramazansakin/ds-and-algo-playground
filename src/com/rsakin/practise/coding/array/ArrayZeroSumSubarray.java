package com.rsakin.practise.coding.array;

// Java program to find
// if there is a zero sum subarray

import java.awt.*;
import java.util.List;
import java.util.*;

public class ArrayZeroSumSubarray {

    // Returns true if arr[]
    // has a subarray with sero sum
    static Boolean subArrayExists(int arr[]) {
        // Creates an empty hashset hs
        Set<Integer> hs = new HashSet<Integer>();

        // Initialize sum of elements
        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];

            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash set
            if (arr[i] == 0 || sum == 0 || hs.contains(sum))
                return true;

            // Add sum to hash set
            hs.add(sum);
        }

        // We reach here only when there is
        // no subarray with 0 sum
        return false;
    }

    // Driver's code
    public static void main(String arg[]) {
        int arr[] = {4, 2, -4, 1, -2, 3};
        int arr2[] = {-3, 2, 3, 1, 6};
        int arr3[] = {1, 2, -3, 4, 2};

        List<Integer> numbers = new ArrayList<>();
        List<Integer> linkedNumbers = new LinkedList<>();

        Map hmap = new HashMap();
        Map htable = new Hashtable();


        Point point = subArrayIndexes(arr);
        if (point != null)
            System.out.println("Array 1 - Found a subarray with 0 sum on - " + point);
        else
            System.out.println("No Such Sub Array Exists!");

        point = subArrayIndexes(arr2);
        if (point != null)
            System.out.println("Array 2 - Found a subarray with 0 sum on - " + point);
        else
            System.out.println("No Such Sub Array Exists!");

        point = subArrayIndexes(arr3);
        if (point != null)
            System.out.println("Array 3 - Found a subarray with 0 sum on - " + point);
        else
            System.out.println("No Such Sub Array Exists!");


    }

    static Point subArrayIndexes(int arr[]) {
        Map<Integer, Integer> hs = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0) return new Point(i, i);
            else if (sum == 0) return new Point(0, i);
            else if (hs.containsKey(sum)) {
                Integer index = hs.get(sum);
                return new Point(index + 1, i);
            }

            hs.put(sum, i);
        }
        return null;
    }

}


class MaxLenZeroSumSub {

    // Returns length of the maximum length
    // subarray with 0 sum
    static int maxLen(int arr[]) {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<>();

        int sum = 0; // Initialize sum of elements
        int max_len = 0; // Initialize result

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];

            if (sum == 0)
                max_len = i + 1;

            // Look this sum in hash table
            Integer prev_i = hM.get(sum);

            // If this sum is seen before, then update
            // max_len if required
            if (prev_i != null)
                max_len = Math.max(max_len, i - prev_i);
            else // Else put this sum in hash table
                hM.put(sum, i);
        }

        return max_len;
    }

    // Drive's code
    public static void main(String arg[]) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

        // Function call
        System.out.println("Length of the longest 0 sum subarray is " + maxLen(arr));

    }

}