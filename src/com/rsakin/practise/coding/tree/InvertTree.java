package com.rsakin.practise.coding.tree;

public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        // Swap the left and right subtrees recursively
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;

        return root;
    }

    public static void main(String[] args) {

        // Sample test case
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(40);

        // Check if the tree is a BST
        TreeNode invertedTree = InvertTree.invertTree(root);
        System.out.println("Root value : " + invertedTree.val);
    }

}
