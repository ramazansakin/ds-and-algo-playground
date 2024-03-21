package com.rsakin.practise.coding.tree;

public class CheckIsSymetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // Empty tree is symmetric
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        // Base case: if both nodes are null, they are mirror reflections of each other
        if (p == null && q == null) {
            return true;
        }
        // If one node is null and the other is not, they are not mirror reflections
        if (p == null || q == null) {
            return false;
        }
        // If the values of the nodes are different, they are not mirror reflections
        if (p.val != q.val) {
            return false;
        }
        // Recursively check if the left subtree of p is a mirror reflection of the right subtree of q
        // and vice versa
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

}
