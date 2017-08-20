package mishra.dev.rahul.linkedlist;

/**
 * https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
 * <p>
 * Created by aleesha on 17/08/17.
 */
public class ReverseLinkedList {

    class LinkedList {
        public Node add(Node head, int data) {
            Node end = new Node(data);
            if (head == null) {
                return end;
            }
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = end;
            return head;
        }

        public Node reverse(Node head) {
            if (head == null) {
                return null;
            }
            Node curr = head;
            Node prev = null;
            Node next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return head;
        }
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
