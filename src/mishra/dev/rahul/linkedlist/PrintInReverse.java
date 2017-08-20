package mishra.dev.rahul.linkedlist;

import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem
 *
 * Created by aleesha on 17/08/17.
 */
public class PrintInReverse {

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

        public void reversePrint(Node head) {
            if(head == null) {
                return;
            }
            reversePrint(head.next);
            System.out.println(head.data);
        }

        public void reversePrintIterative(Node head) {
            if (head == null) {
                return;
            }
            Stack<Integer> stack = new Stack<>();
            while (head != null) {
                stack.push(head.data);
                head = head.next;
            }
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
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
