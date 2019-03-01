package com.interview.linkedlist;

import model.linkedlist.Node;

/**
 * 142. Linked List Cycle II
 *
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

    /**
     * Detects cycle using Floyd Cycle Detection Algorithm.
     * Time complexity O(n)
     */
    public Node detectCycle(Node head) {
        if (head == null || head.next == null) return null;

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        LinkedListCycleII ll = new LinkedListCycleII();

        int[] arr1 = {3,2,0,4};
        int[] arr2 = {1};

        Node head  = ll.initLinkedList(arr2, 0);
        Node cycle = ll.detectCycle(head);

        if (cycle == null)
            System.out.println("null");
        else
            System.out.println(cycle.val);
    }


    /**
     * Initialize new linked list based on given array and
     * point tail of list to the given list index.
     *
     * @param arr - array with linked list values
     * @param cycleIndex - index of element tail points to.
     */
    private Node initLinkedList(int[] arr, int cycleIndex) {
        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> current = head, temp, cycle = null;

        for (int i = 1; i < arr.length; i++) {
            temp = new Node<>(arr[i]);
            current.next = temp;
            current = temp;
            if (i == cycleIndex)
                cycle = current;
        }
        current.next = cycle;

        return head;
    }
}
