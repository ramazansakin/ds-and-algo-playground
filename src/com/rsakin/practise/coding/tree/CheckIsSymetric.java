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


    // 2.way with in-order traversal left and right sub-trees cross
    public boolean isSymmetric2(TreeNode root) {
        StringBuilder leftInorder = new StringBuilder();
        StringBuilder rightPostorder = new StringBuilder();

        inorderTraversal(root, leftInorder);
        mirroredInorderTraversal(root, rightPostorder);

        return leftInorder.toString().contentEquals(rightPostorder);
    }

    private void inorderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#"); // Placeholder for null nodes
            return;
        }
        inorderTraversal(node.left, sb);
        sb.append(node.val);
        inorderTraversal(node.right, sb);
    }

    private void mirroredInorderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#"); // Placeholder for null nodes
            return;
        }
        mirroredInorderTraversal(node.right, sb);
        sb.append(node.val);
        mirroredInorderTraversal(node.left, sb);
    }

    public static void main(String[] args) {

        // Symmetric tree with depth 5
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        root1.left.left.left = new TreeNode(5);
        root1.left.left.right = new TreeNode(6);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);
        root1.right.left.left = new TreeNode(8);
        root1.right.left.right = new TreeNode(7);
        root1.right.right.left = new TreeNode(6);
        root1.right.right.right = new TreeNode(5);

        System.out.println("Is the tree symmetric? " + new CheckIsSymetric().isSymmetric2(root1)); // Output: true

        // Non-symmetric tree with depth 5
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        root2.left.right.left = new TreeNode(4);
        root2.left.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(5);
        root2.right.right.right = new TreeNode(4);

        System.out.println("Is the tree symmetric? " + new CheckIsSymetric().isSymmetric2(root2)); // Output: false
    }

}
