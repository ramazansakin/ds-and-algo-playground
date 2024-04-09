package com.rsakin.practise.leetcode;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeAverageLevelSolution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        if (root == null) return averages;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            double average = levelSum / levelSize;
            averages.add(average);
        }

        return averages;
    }

    public static void main(String[] args) {
        TreeAverageLevelSolution main = new TreeAverageLevelSolution();

        // Test Case 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        List<Double> result1 = main.averageOfLevels(root1);
        System.out.println("Average of levels for Test Case 1: " + result1);

        // Test Case 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(0);
        root2.left.right = new TreeNode(2);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(6);
        List<Double> result2 = main.averageOfLevels(root2);
        System.out.println("Average of levels for Test Case 2: " + result2);
    }

}
