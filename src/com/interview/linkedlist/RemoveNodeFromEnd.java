package com.interview.linkedlist;

import model.linkedlist.LinkedList;
import model.linkedlist.Node;

/**
 * 19. Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Time complexity:  O(n) - length of linked list
 * Space complexity: O(1) - no extra storage is used
 */
public class RemoveNodeFromEnd {

    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null || head.next == null) return null; // empty or one element

        Node curr = head, last = head;

        for (int i = 0; i < n; i++) {
            last = last.next;
        }

        // if first element to be removed, n equals first element
        if (last == null) return curr.next;

        while (last != null && last.next != null) {
            last = last.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
    }

    public static void main(String[] args) {
        Node l1 = LinkedList.initList(12345);

        removeNthFromEnd(l1, 5);

    }
}
