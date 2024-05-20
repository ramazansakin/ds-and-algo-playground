package com.rsakin.practise.coding.linkedlist;

class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

public class LinkedListReverse {

    // Reverse LinkedList - recursively
    static void printReverse(Node head) {
        if (head == null)
            return;

        printReverse(head.next);

        // Trace all the list and then print from last to first - reverse
        System.out.print(head.data + " ");
    }

    static Node push(Node head, int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;

        return head;
    }

    static int printList(Node head) {
        int i = 0;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
            i++;
        }

        return i;
    }

    public static void main(String[] args) {
        /* Start with the empty list */
        Node head = null;

        // list nodes are as 6 5 4 3 2 1
        head = push(head, 1);
        head = push(head, 2);
        head = push(head, 3);
        head = push(head, 4);
        head = push(head, 5);
        head = push(head, 6);

        System.out.println("Given linked list:");
        // printlist print the list and return the size of the list
        int n = printList(head);

        // print reverse list
        System.out.println("\nReversed Linked list with size: " + n);
        printReverse(head);
        System.out.println();
    }

}