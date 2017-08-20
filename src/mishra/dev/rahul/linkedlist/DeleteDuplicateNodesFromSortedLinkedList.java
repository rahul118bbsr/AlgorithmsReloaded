package mishra.dev.rahul.linkedlist;

/**
 * Created by aleesha on 17/08/17.
 */
public class DeleteDuplicateNodesFromSortedLinkedList {

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

        public Node deleteDuplicateNodes(Node head) {
            if (head == null) {
                return null;
            }
            Node curr = head;
            while (curr.next != null) {
                if (curr.data == curr.next.data) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
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
