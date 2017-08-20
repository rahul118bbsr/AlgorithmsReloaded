package mishra.dev.rahul.linkedlist;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
 * <p>
 * Created by aleesha on 17/08/17.
 */
public class InsertNodeAtSpecificPositionOfLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new InsertNodeAtSpecificPositionOfLinkedList().new LinkedList();
        Node head = linkedList.addNodeAtSpecificPosition(null, 3, 0);
        head = linkedList.addNodeAtSpecificPosition(head, 5, 1);
        head = linkedList.addNodeAtSpecificPosition(head, 4, 2);
        head = linkedList.addNodeAtSpecificPosition(head, 2, 3);
        head = linkedList.addNodeAtSpecificPosition(head, 10, 1);
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

        public Node addNodeAtSpecificPosition(Node head, int data, int position) {
            Node newNode = new Node(data);
            if (head == null || position == 0) {
                newNode.next = head;
                return newNode;
            }

            int index = 0;
            Node curr = head;
            while (curr != null) {
                if (index + 1 == position) {
                    newNode.next = curr.next;
                    curr.next = newNode;
                    return head;
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

        @Override
        public String toString() {
            return data + "";
        }
    }
}
