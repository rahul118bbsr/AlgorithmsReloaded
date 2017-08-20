package mishra.dev.rahul.linkedlist;

/**
 * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
 *
 * Created by aleesha on 17/08/17.
 */
public class FindMergePointOfTwoLinkedLists {

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

        public int findMergeNode(Node headA, Node headB) {
            if(headA == null || headB == null) {
                return -1;
            }
            int count = 0;
            Node currA = headA;
            Node currB = headB;
            while(count < 2) {
                if(currA == currB) {
                    return currA.data;
                }
                currA = currA.next == null ? currB : currA.next;
                currB = currB.next == null ? currA : currB.next;
                count = currA == headB ? count + 1 : count;
            }
            return -1;
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
