package com.rsakin.practise.coding.tree;

public class CheckSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Try to travers both trees as in-order traversal and check all the values are same
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

}
