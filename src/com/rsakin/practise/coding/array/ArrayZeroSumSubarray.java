package com.rsakin.practise.coding.array;

// Java program to find
// if there is a zero sum subarray


import java.awt.*;
import java.util.*;

public class ArrayZeroSumSubarray {

    // Returns true if arr[]
    // has a subarray with zero-sum
    static Boolean subArrayExists(int[] arr) {
        // Creates an empty hashset hs
        Set<Integer> hs = new HashSet<>();

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

        // We reach here only when there is no subarray with 0 sum
        return false;
    }

    // Driver's code
    public static void main(String[] args) {
        int[] arr = {4, 2, -4, 1, -2, 3};
        int[] arr2 = {-3, 2, 3, 1, 6};
        int[] arr3 = {1, 2, -3, 4, 2};

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

    static Point subArrayIndexes(int[] arr) {
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
    public static int maxLengthZeroSumSubarray(int[] nums) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int maxLength = 0;
        int sum = 0;

        // Insert initial sum and index (-1) into the map
        sumIndexMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // If the sum is encountered again, update the maxLength
            if (sumIndexMap.containsKey(sum)) {
                int length = i - sumIndexMap.get(sum);
                maxLength = Math.max(maxLength, length);
            } else {
                // Otherwise, insert the sum and its index into the map
                sumIndexMap.put(sum, i);
            }
        }

        return maxLength;
    }

    // Drive's code
    public static void main(String[] arg) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        // Function call
        System.out.println("Length of the longest 0 sum subarray is " + maxLengthZeroSumSubarray(arr));
        System.out.println("----------------");

    }

}