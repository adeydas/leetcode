package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5

 Explanation: https://abhi.im/leetcode-remove-all-elements-from-a-linked-list-that-have-value-val/
 */
public class RemoveLinkedListElements extends TestCase {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.next == null) {
            if (head.val == val)
                return null;
            else
                return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode temp = dummy;

        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return dummy.next;
    }

    public void testOne() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six1 = new ListNode(6);
        ListNode six2 = new ListNode(6);
        one.next = two;
        two.next = six1;
        six1.next = three;
        three.next = four;
        four.next = five;
        five.next = six2;

        ListNode head = removeElements(one, 6);
        String r = "";
        while (head != null) {
            r += head.val;
            head = head.next;
        }

        assertTrue(r.equals("12345"));
    }
    public void testTwo() {
        ListNode one1 = new ListNode(1);
        ListNode one2 = new ListNode(1);
        one1.next = one2;

        ListNode head = removeElements(one1, 1);
        String r = "";
        while (head != null) {
            r += head.val;
            head = head.next;
        }

        assertTrue(r.equals(""));
    }
}
