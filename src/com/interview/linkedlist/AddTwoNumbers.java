package com.interview.linkedlist;

import model.linkedlist.Node;

/**
 * 2. Add Two Numbers (Represented As Linked List)
 *
 * Reference:
 * https://leetcode.com/problems/add-two-numbers/
 * https://www.geeksforgeeks.org/sum-of-two-linked-lists/
 */
public class AddTwoNumbers {

    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0), current = dummy;
        int carry = 0, sum, a, b;

        while (l1 != null || l2 != null) {
            a = (l1 != null) ? l1.val : 0;
            b = (l2 != null) ? l2.val : 0;
            sum = a + b + carry;

            current.next = new Node(sum % 10);
            current = current.next;
            carry = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) current.next = new Node(carry);

        return dummy.next;
    }


    /**
     * Test Cases:
     */
    public static void main(String[] args) {
        AddTwoNumbers ll = new AddTwoNumbers();

        Node l1 = initList(5);
        Node l2 = initList(5);

        Node l3 = ll.addTwoNumbers(l1, l2);

        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }

    }


    /**
     * Initialize a new linked list based on the given number in a reverse way
     */
    private static Node initList(int num) {
        num = reverseInteger(num);

        Node head = new Node(num % 10);
        Node current = head;
        num = num / 10;

        while (num != 0) {
            current.next = new Node(num % 10);
            num = num / 10;
            current = current.next;
        }

        return head;
    }

    /**
     * Reverse integer
     */
    private static int reverseInteger(int num) {
        int reverse = 0, remainder;
        while (num != 0) {
            remainder = num % 10;
            reverse   = reverse * 10 + remainder;
            num       = num / 10;
        }
        return reverse;
    }
}
