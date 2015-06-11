package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionLL extends TestCase {

    /**
     * Cut the longer list to the size of the shorter one.
     * Iterate through both the lists.
     * If a match is found, return
     * else if end of either list is reached without a match, return null.
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int firstCount = 0;
        int secondCount = 0;

        //First number of nodes in first list
        ListNode A = headA;
        while (A != null) {
            firstCount = firstCount + 1;
            A = A.next;
        }
        //Find number of nodes in second list
        ListNode B = headB;
        while (B != null) {
            secondCount = secondCount + 1;
            B = B.next;
        }

        if (firstCount > secondCount) {
            int diff = firstCount - secondCount;
            while (diff > 0) {
                headA = headA.next;
                diff = diff - 1;
            }
        } else if (secondCount > firstCount) {
            int diff = secondCount - firstCount;
            while (diff > 0) {
                headB = headB.next;
                diff = diff - 1;
            }
        }

        return getNode(headA, headB);
    }

    private ListNode getNode(ListNode A, ListNode B) {
        while (A!= null && B!=null) {
            if (A == B)
                return A;
            A = A.next; B = B.next;
        }
        return null;
    }
}
