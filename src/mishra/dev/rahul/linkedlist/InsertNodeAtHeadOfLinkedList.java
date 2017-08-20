package mishra.dev.rahul.linkedlist;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem
 * <p>
 * Created by aleesha on 17/08/17.
 */
public class InsertNodeAtHeadOfLinkedList {

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

        public Node addNodeAtHead(Node head, int data) {
            Node first = new Node(data);
            first.next = head;
            return first;
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
