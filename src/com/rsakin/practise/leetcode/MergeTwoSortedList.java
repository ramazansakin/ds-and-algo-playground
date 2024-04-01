package com.rsakin.practise.leetcode;

public class MergeTwoSortedList {

    // Recursive
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    // Iterative
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode iter = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }

        if (l1 != null) {
            iter.next = l1;
        } else if (l2 != null) {
            iter.next = l2;
        }

        return result.next; // ignore the first Node with 0 value
    }

    public static void main(String[] args) {

        // create a sample list1
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(8);

        // combine them
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // reference to the first ListNode as head
        ListNode list1 = node;

        // create a sample list2
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(4);
        ListNode node25 = new ListNode(5);

        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;

        ListNode list2 = node21;

        System.out.println("Solution with Recursive : ");
        printLL(mergeTwoLists(list1, list2));

        // you can check the input lists are being modified
//        printLL(list1);
//        printLL(list2);

    }

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ---> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

}
