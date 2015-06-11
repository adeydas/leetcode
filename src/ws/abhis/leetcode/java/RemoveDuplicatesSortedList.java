package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesSortedList extends TestCase {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        ListNode temp = head;


        while (temp != null) {
            ListNode t = temp.next;
            while (t != null && temp.val == t.val)
                t = t.next;
            temp.next = t;
            temp = temp.next;
        }

        return head;
    }

    public void testOne() {
        ListNode one1 = new ListNode(1);
        ListNode one2 = new ListNode(1);
        ListNode two = new ListNode(2);

        one1.next = one2;
        one2.next = two;

        deleteDuplicates(one1);
    }
    public void testTwo() {
        ListNode one1 = new ListNode(1);
        ListNode one2 = new ListNode(1);
        one1.next=one2;
        deleteDuplicates(one1);
    }
    public void testThree() {
        ListNode one2 = new ListNode(1);
        ListNode two = new ListNode(2);
        one2.next = two;

        deleteDuplicates(one2);
    }
    public void testFour() {
        ListNode one1 = new ListNode(1);
        ListNode one2 = new ListNode(1);
        ListNode one3 = new ListNode(1);
        ListNode one4 = new ListNode(1);
        one1.next = one2;
        one2.next = one3;
        one3.next = one4;

        deleteDuplicates(one1);
    }
}
