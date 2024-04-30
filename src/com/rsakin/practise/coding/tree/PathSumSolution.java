package com.rsakin.practise.coding.tree;

public class PathSumSolution {


    // While moving on the tree from root to each leaf, I need to sum up all the values towards the leaf
    // then compare with the target number, if there is any path which has the same sum with target, then return true, o.w false
    // we can traverse the list in-order approach and try to sum up all paths

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // if it's a leaf node not an internal node
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


}
