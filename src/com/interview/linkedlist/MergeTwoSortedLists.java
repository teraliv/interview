package com.interview.linkedlist;

import model.linkedlist.Node;

/**
 * 21. Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
@SuppressWarnings("Duplicates")
public class MergeTwoSortedLists {

    public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0), current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = new Node(l1.val);
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                current.next = new Node(l2.val);
                l2 = l2.next;
            }
            else {
                current.next = new Node(l1.val);
                l1 = l1.next;
            }
            current = current.next;
        }
        while (l1 != null) {
            current.next = new Node(l1.val);
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            current.next = new Node(l2.val);
            current = current.next;
            l2 = l2.next;
        }

        return dummy.next;
    }
}
