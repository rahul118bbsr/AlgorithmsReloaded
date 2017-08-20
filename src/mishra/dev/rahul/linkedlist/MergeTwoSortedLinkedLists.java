package mishra.dev.rahul.linkedlist;

/**
 * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
 *
 * Created by aleesha on 17/08/17.
 */
public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        LinkedList linkedList = new MergeTwoSortedLinkedLists().new LinkedList();
        Node headA = linkedList.add(null, 1);
        headA = linkedList.add(headA, 3);
        headA = linkedList.add(headA, 5);
        headA = linkedList.add(headA, 6);

        Node headB = linkedList.add(null, 2);
        headB = linkedList.add(headB, 4);
        headB = linkedList.add(headB, 7);

        Node mergedNode = linkedList.mergeLists(headA, headB);
        System.out.println();
    }


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

        public Node mergeLists(Node headA, Node headB) {
            if(headA == null) {
                return headB;
            }
            if(headB == null) {
                return headA;
            }
            Node mergeHead = new Node(Integer.MIN_VALUE);
            Node curr = mergeHead;
            while(headA != null || headB != null) {
                if(headB == null || (headA != null && headA.data <= headB.data)) {
                    curr.next = new Node(headA.data);
                    headA = headA.next;
                } else if(headA == null || (headB != null && headB.data < headA.data)) {
                    curr.next = new Node(headB.data);
                    headB = headB.next;
                }
                curr = curr.next;
            }
            return mergeHead.next;
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
