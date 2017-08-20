package mishra.dev.rahul.linkedlist;

/**
 * https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem
 * <p>
 * Created by aleesha on 17/08/17.
 */
public class DeleteNode {

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
            curr = curr.next;
            return head;
        }

        public Node delete(Node head, int position) {
            if (position == 0) {
                return head.next;
            }
            int index = 0;
            Node curr = head;
            while (curr != null) {
                if (index + 1 == position) {
                    curr.next = curr.next.next;
                }
                index++;
                curr = curr.next;
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
