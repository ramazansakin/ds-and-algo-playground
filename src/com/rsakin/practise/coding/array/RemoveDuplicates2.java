package com.rsakin.practise.coding.array;

public class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        // Handle edge case where array is empty
        if (nums.length == 0) {
            return 0;
        }

        int count = 1; // Counter for the current element
        int k = 1; // Index where the next unique element should be placed

        for (int i = 1; i < nums.length; i++) {
            // If the current element is equal to the previous element
            if (nums[i] == nums[i - 1]) {
                // Increment the count
                count++;
            } else {
                // Reset the count to 1 for the new unique element
                count = 1;
            }

            // If the count is less than or equal to 2, keep the current element
            if (count <= 2) {
                // Place the current element at the next position where a unique element should be placed
                nums[k++] = nums[i];
            }
        }

        return k;
    }

    public static void main(String[] args) {
        RemoveDuplicates2 solution = new RemoveDuplicates2();

        // Test Case 1: No Duplicates
        int[] nums1 = {1, 2, 3, 4, 5};
        int result1 = solution.removeDuplicates(nums1);
        System.out.println("Test Case 1: " + result1); // Expected: 5
        System.out.print("Modified Array: ");
        for (int i = 0; i < result1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println("------------------");

        // Test Case 2: Some Duplicates Exceeding Twice
        int[] nums2 = {1, 1, 1, 2, 2, 3, 3, 3, 3, 4};
        int result2 = solution.removeDuplicates(nums2);
        System.out.println("Test Case 2: " + result2); // Expected: 7
        System.out.print("Modified Array: ");
        for (int i = 0; i < result2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println("------------------");

        // Test Case 3: All Elements Are the Same
        int[] nums3 = {2, 2, 2, 2, 2};
        int result3 = solution.removeDuplicates(nums3);
        System.out.println("Test Case 3: " + result3); // Expected: 2
        System.out.print("Modified Array: ");
        for (int i = 0; i < result3; i++) {
            System.out.print(nums3[i] + " ");
        }
        System.out.println();

    }


}
