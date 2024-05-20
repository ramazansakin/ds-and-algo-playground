package com.rsakin.practise.coding.stack;

import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // Iterate the array from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            // Pop elements from the stack while they are smaller than the current element
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            // If stack is empty, there is no greater element to the right
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            // Push current element onto the stack
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        NextGreaterElement solution = new NextGreaterElement();
        int[] nums = {4, 5, 2, 25};
        int[] result = solution.nextGreaterElement(nums);

        System.out.println("Next Greater Element:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " --> " + result[i]);
        }

    }

}