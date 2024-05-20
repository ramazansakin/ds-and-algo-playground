package com.rsakin.practise.coding.linkedlist;

// 2 types of sorting you can do here
public class SortLinkedListSolution {

    // We can sort the linked-list by merge-sort algorithm
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;   // to cut head in middle, use 2 isolated part like head and slow, then merge them as sorted
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append the remaining nodes of l1 or l2
        if (l1 != null) current.next = l1;
        else current.next = l2;

        return dummy.next;
    }

    public static void main(String[] args) {
        // Test case 1: Empty list
        ListNode head1 = null;
        SortLinkedListSolution solution = new SortLinkedListSolution();
        ListNode sortedList1 = solution.sortList(head1);
        printList(sortedList1); // Output: null

        // Test case 2: List with one element
        ListNode head2 = new ListNode(5);
        ListNode sortedList2 = solution.sortList(head2);
        printList(sortedList2); // Output: 5

        // Test case 3: List with multiple elements
        ListNode head3 = new ListNode(3);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(4);
        head3.next.next.next = new ListNode(1);
        ListNode sortedList3 = solution.sortList(head3);
        printList(sortedList3); // Output: 1 -> 2 -> 3 -> 4

        // Test case 4: List with duplicate elements
        ListNode head4 = new ListNode(5);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(5);
        head4.next.next.next = new ListNode(1);
        head4.next.next.next.next = new ListNode(8);
        head4.next.next.next.next.next = new ListNode(3);

        ListNode sortedList4 = solution.sortList(head4);
        printList(sortedList4); // Output: 1 -> 2 -> 3 -> 5 -> 5 -> 8

    }

    // Helper method to print the elements of a linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


    // We can also use Bubble-Sort to make it easier to understand
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        boolean swapped;
        ListNode current;
        ListNode end = null;

        do {
            swapped = false;
            current = head;

            while (current.next != end) {
                if (current.val > current.next.val) {
                    swap(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }

            end = current; // Optimization, no need to check already sorted last indexes
        } while (swapped);

        return head;
    }

    private void swap(ListNode a, ListNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

}
