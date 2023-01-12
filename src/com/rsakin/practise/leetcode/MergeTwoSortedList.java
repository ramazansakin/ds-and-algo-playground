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
        ListNode head = new ListNode(0);
        ListNode handler = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }

        if (l1 != null) {
            handler.next = l1;
        } else if (l2 != null) {
            handler.next = l2;
        }

        return head.next;
    }

    public static void main(String[] args) {

        // create a sample list1
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(8);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

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
        RemoveNthFromLL.printLL(mergeTwoLists(list1, list2));

    }

}
