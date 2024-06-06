package com.rsakin.practise.coding.array;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2) {
        int index1 = m - 1; // Index of last element in nums1
        int index2 = nums2.length - 1; // Index of last element in nums2
        int mergedIndex = m + index2; // Index where the next merged element should be placed

        // Merge elements from both arrays starting from the end
        while (index1 >= 0 && index2 >= 0) {
            // Compare elements from nums1 and nums2, place the larger one at the end of nums1
            if (nums1[index1] > nums2[index2]) {
                nums1[mergedIndex--] = nums1[index1--];
            } else {
                nums1[mergedIndex--] = nums2[index2--];
            }
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (index2 >= 0) {
            nums1[mergedIndex--] = nums2[index2--];
        }

        // print the result
        for (int j : nums1)
            System.out.print(j + " ");

    }


    public static void main(String[] args) {
        int[] nums1 = new int[9];
        int[] valuesToAdd = {0, 0, 0, 1, 2, 3};

        System.arraycopy(valuesToAdd, 0, nums1, 0, valuesToAdd.length);

        int[] nums2 = {2, 5, 6};

        merge(nums1, 6, nums2);

    }

}