package com.rsakin.practise.leetcode;

public class SwapNodePairs {

    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode current = preHead;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            second.next = first;
            current = current.next.next;
        }
        return preHead.next;
    }

}
