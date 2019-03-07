package com.interview.linkedlist;

import model.linkedlist.LinkedList;
import model.linkedlist.Node;

/**
 * 24. Swap Nodes in Pairs
 *
 *https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public static Node swapPairs(Node l1) {
        if (l1 == null) return null;    // empty list
        if (l1.next == null) return l1; // one element list

        Node head = l1.next;            // keep head node
        Node p1 = l1, p2 = l1.next;     // pointer to 1st node
        Node prev = p1;                 // keep track of previous node

        while (p1 != null && p2 != null) {
            prev.next = p2;     // update previous node
            p1.next = p2.next;  // swap p1 node
            p2.next = p1;       // swap p2 node

            prev = p1;          // move previous
            p1 = p1.next;       // move p1
            if (p1 != null) p2 = p1.next; // move p2
        }

        return head;
    }

    public static void main(String[] args) {
        Node l1 = LinkedList.initList(2534622);

        Node head = swapPairs(l1);
        LinkedList.print(head);
    }
}
