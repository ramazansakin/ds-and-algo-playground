package com.rsakin.practise.coding.tree;

import java.util.ArrayList;
import java.util.List;

public class CheckValidBST {

    public boolean isBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);

        // Check if the list is sorted
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) <= values.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, values);
        values.add(node.val);
        inOrderTraversal(node.right, values);
    }

    public static void main(String[] args) {
        CheckValidBST checker = new CheckValidBST();

        // Example usage:
        // Construct a BST
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(40);


        // Check if the tree is a BST
        boolean result = checker.isBST(root);
        System.out.println("Is BST: " + result); // Output: true
    }

}
