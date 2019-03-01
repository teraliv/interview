package model.linkedlist;

/**
 * Linked List Node
 */
public class Node<T> {
    public T val;
    public Node next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }
}
