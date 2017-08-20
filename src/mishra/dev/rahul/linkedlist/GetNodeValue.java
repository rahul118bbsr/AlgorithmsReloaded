package mishra.dev.rahul.linkedlist;

/**
 * https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
 *
 * Created by aleesha on 17/08/17.
 */
public class GetNodeValue {

    class LinkedList {
        public Node add(Node head, int data) {
            Node end = new Node(data);
            if(head == null) {
                return end;
            }
            Node curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = end;
            return head;
        }

        public int getNode(Node head, int positionFromTail) {
            if(head == null) {
                return 0;
            }
            Node forwardNode = head;
            while(positionFromTail != 0) {
                forwardNode = forwardNode.next;
                --positionFromTail;
            }
            while(forwardNode.next != null) {
                head = head.next;
                forwardNode = forwardNode.next;
            }
            return head.data;
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
