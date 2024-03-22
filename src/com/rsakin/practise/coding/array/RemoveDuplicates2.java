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

    }

}
