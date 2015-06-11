package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists extends TestCase {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null && l2!= null)
            return l2;
        if (l1!=null && l2 == null)
            return l1;

        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode dummyStart = head;

        while (l1 != null && l2 != null) {

            while (l1.val < l2.val) {
                dummyStart.next = l1;
                l1=l1.next;
                dummyStart = dummyStart.next;
                if (l1 == null) break;
            }
            dummyStart.next = l2;
            dummyStart = dummyStart.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            while (l1 != null) {
                dummyStart.next = l1;
                l1 = l1.next;
                dummyStart = dummyStart.next;
            }
        }
        if (l2 != null) {
            while (l2.next != null) {
                dummyStart.next = l2;
                l2 = l2.next;
                dummyStart = dummyStart.next;
            }
        }
        return head.next;
    }

    public void testOne() {
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(1);

        mergeTwoLists(one, two);
    }
    public void testTwo() {
        ListNode mTen = new ListNode(-10);
        ListNode mNine = new ListNode(-9);
        ListNode mSix = new ListNode(-6);
        ListNode mFour = new ListNode(-4);
        ListNode one = new ListNode(1);
        ListNode nine1 = new ListNode(9);
        ListNode nine2 = new ListNode(9);
        mTen.next = mNine;
        mNine.next = mSix;
        mSix.next = mFour;
        mFour.next = one;
        one.next = nine1;
        nine1.next = nine2;



        ListNode mFive = new ListNode(-5);
        ListNode mThree = new ListNode(-3);
        ListNode zero = new ListNode(0);
        ListNode seven = new ListNode(7);
        ListNode eight1 = new ListNode(8);
        ListNode eight2 = new ListNode(8);
        mFive.next = mThree;
        mThree.next = zero;
        zero.next = seven;
        seven.next = eight1;
        eight1.next = eight2;



        mergeTwoLists(mTen, mFive);
    }
}
