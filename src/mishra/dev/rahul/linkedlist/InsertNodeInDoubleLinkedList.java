package mishra.dev.rahul.linkedlist;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
 *
 * Created by aleesha on 17/08/17.
 */
public class InsertNodeInDoubleLinkedList {

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
            end.prev = curr;
            return head;
        }

        public Node sortedInsert(Node head, int data) {
            Node newNode = new Node(data);
            if(head == null) {
                return newNode;
            }
            Node curr = head;
            while(curr.next != null) {
                if(curr.data <= data && data <= curr.next.data) {
                    newNode.next = curr.next;
                    newNode.prev = curr;
                    newNode.next.prev = newNode;
                    return head;
                }
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
            return head;
        }

    }

    class Node {
        int data;
        Node prev;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
}
