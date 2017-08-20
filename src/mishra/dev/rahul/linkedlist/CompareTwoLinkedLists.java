package mishra.dev.rahul.linkedlist;

/**
 * https://www.hackerrank.com/challenges/compare-two-linked-lists/problem
 * <p>
 * Created by aleesha on 17/08/17.
 */
public class CompareTwoLinkedLists {
    public static void main(String[] args) {
        LinkedList linkedList = new CompareTwoLinkedLists().new LinkedList();
        Node headA = linkedList.add(null, 1);
        headA = linkedList.add(headA, 2);
        headA = linkedList.add(headA, 3);
        headA = linkedList.add(headA, 4);

        Node headB = linkedList.add(null, 1);
        headB = linkedList.add(headB, 2);
        headB = linkedList.add(headB, 3);
        headB = linkedList.add(headB, 4);
        System.out.println(linkedList.compareLists(headA, headB));
    }

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

        public int compareLists(Node headA, Node headB) {
            if (headA == null && headB == null) {
                return 1;
            }
            if (headA == null || headB == null) {
                return 0;
            }

            while (headA != null && headB != null && headA.data == headB.data) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA == null && headB == null ? 1 : 0;
        }
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }
}
