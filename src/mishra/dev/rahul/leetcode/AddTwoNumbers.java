package mishra.dev.rahul.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/#/description
 * <p>
 * Created by aleesha on 24/07/17.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        LinkedList linkedList = new AddTwoNumbers().new LinkedList();
        ListNode l1 = linkedList.add(null, 2);
        linkedList.add(l1, 4);
        linkedList.add(l1, 3);

        ListNode l2 = linkedList.add(null, 5);
        linkedList.add(l2, 6);
        linkedList.add(l2, 4);

        ListNode result = linkedList.addTwoNumbers(l1, l2);
        System.out.println();
    }

    class LinkedList {
        public ListNode add(ListNode head, int value) {
            ListNode end = new ListNode(value);
            if (head == null) {
                return end;
            }
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = end;
            return head;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            ListNode result = new ListNode(0);
            ListNode curr1 = l1;
            ListNode curr2 = l2;
            ListNode resultPtr = result;
            int sum = 0;
            int carry = 0;
            while (curr1 != null || curr2 != null) {
                if (curr1 == null) {
                    sum = curr2.val + carry;
                    carry = sum / 10;
                    resultPtr.next = new ListNode(sum % 10);
                    curr2 = curr2.next;
                } else if (curr2 == null) {
                    sum = curr1.val + carry;
                    carry = sum / 10;
                    resultPtr.next = new ListNode(sum % 10);
                    curr1 = curr1.next;
                } else {
                    sum = curr1.val + curr2.val + carry;
                    carry = sum / 10;
                    resultPtr.next = new ListNode(sum % 10);
                    curr1 = curr1.next;
                    curr2 = curr2.next;
                }
                resultPtr = resultPtr.next;
            }

            if(carry > 0) {
                resultPtr.next = new ListNode(carry);
            }
            return result.next;
        }
    }

    class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + " ";
        }
    }
}
