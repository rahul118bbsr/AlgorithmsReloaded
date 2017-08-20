package mishra.dev.rahul.linkedlist;

/**
 * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
 * <p>
 * Created by aleesha on 17/08/17.
 */
public class CycleDetection {

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

        public boolean hasCycle(Node head) {
            if (head == null) {
                return false;
            }
            Node slow = head;
            Node fast = head.next;
            while (fast != null && fast.next != null) {
                if (slow == fast) {
                    Node loopStartNode = findStartingNodeOfLoop(head, fast);
                    return true;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
        }

        /**
         * Bonus Question
         */

        public Node findStartingNodeOfLoop(Node head, Node fast) {
            Node slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
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
