package com.rsakin.practise.leetcode;

public class ContainerWithMostWaterSolution {

    public int maxArea(int[] height) {
        int startInd = 0, endInd = height.length - 1, maxArea = 0;
        while (startInd < endInd) {
            // weight = end Index - start Index
            maxArea = Math.max(maxArea, Math.min(height[startInd], height[endInd]) * (endInd - startInd));
            if (height[startInd] <= height[endInd]) ++startInd;
            else --endInd;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWaterSolution solution = new ContainerWithMostWaterSolution();

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum area: " + solution.maxArea(height)); // Output: 49
    }

}
