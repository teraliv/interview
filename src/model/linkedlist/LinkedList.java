package model.linkedlist;

public class LinkedList {

    /**
     * Initialize a new linked list based on the given number
     */
    public static Node initList(int num) {
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
