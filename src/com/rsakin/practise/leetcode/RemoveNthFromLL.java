package com.rsakin.practise.leetcode;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveNthFromLL {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head, lastNthBefore = head;
        int index = 0;
        while (index++ < n && temp != null) {
            temp = temp.next;
        }
        if (index != n) return null;

        if (temp == null) {
            head = head.next;
            return head;
        }
        while (temp.next != null) {
            temp = temp.next;
            lastNthBefore = lastNthBefore.next;
        }
        lastNthBefore.next = lastNthBefore.next.next;
        return head;
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ---> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printLL(node);

        node = removeNthFromEnd(node, 8);

        printLL(node);

    }


    // Alternative solution like, we can find the length of the LL by iterating to null
    // then get size - n = firstNth position, if its lower than 0, return null
    // If its greater or equal to 0, then traverse the LL by firstNth - 1 ( - 1 for placing previous node to delete next easily) and just assign it like,
    // temp.next = temp.next.next to delete temp


}
