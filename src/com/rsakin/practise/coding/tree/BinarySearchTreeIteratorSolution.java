package com.rsakin.practise.coding.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BSTIterator {

    List<Integer> list;
    int pointer;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        pointer = 0;
        // traverse the tree
        createList(root);
    }

    // in-order traversal to build BST as List<Node>
    public void createList(TreeNode node) {
        if (node == null) return;

        createList(node.left);
        list.add(node.val);
        createList(node.right);
    }

    public int next() {
        return list.get(pointer++);
    }

    public boolean hasNext() {
        return pointer < list.size();
    }
}

public class BinarySearchTreeIteratorSolution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.next());    // Output: 3
        System.out.println(bSTIterator.next());    // Output: 7
        System.out.println(bSTIterator.hasNext()); // Output: true
        System.out.println(bSTIterator.next());    // Output: 9
        System.out.println(bSTIterator.hasNext()); // Output: true
        System.out.println(bSTIterator.next());    // Output: 15
        System.out.println(bSTIterator.hasNext()); // Output: true
        System.out.println(bSTIterator.next());    // Output: 20
        System.out.println(bSTIterator.hasNext()); // Output: false
    }

}
