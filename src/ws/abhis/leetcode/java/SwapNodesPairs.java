package ws.abhis.leetcode.java;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesPairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && slow != fast) {
            slow.next = fast.next;
            fast.next = slow;
            if (prev == null) {
                prev = fast;
                head = prev;
                prev = prev.next;
            } else {
                prev.next = fast;
                prev = prev.next.next;
            }
            slow = slow.next;
            if (slow == null)
                break;
            fast = fast.next.next.next;
        }
        return head;
    }

    public static void main(String... args) {

    }
}
