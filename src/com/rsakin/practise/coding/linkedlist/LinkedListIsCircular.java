package com.rsakin.practise.coding.linkedlist;

public class LinkedListIsCircular {

    /* Link list Node */
    static class Node {
        int data;
        Node next;
    }

    /*
     This function returns true if given linked
     list is circular, else false.
    */
    static boolean isCircular(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    // Utility function to create a new node.
    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    // Driver code
    public static void main(String[] args) {
        /* Start with the empty list */
        Node head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);

        System.out.print(isCircular(head) ? "Yes\n" : "No\n");

        // Making linked list circular
        head.next.next.next.next = head;

        System.out.print(isCircular(head) ? "Yes\n" : "No\n");
    }

}