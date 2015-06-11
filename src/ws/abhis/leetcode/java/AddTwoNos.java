package ws.abhis.leetcode.java;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * https://abhi.im/leetcode-add-two-numbers/
 */
public class AddTwoNos {

    public class ListNode {
          int val;
         ListNode next;
         ListNode(int x) { val = x; }
        ListNode (int x, ListNode next) { val =x; this.next = next;}
      }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;

        ListNode result = null;
        ListNode resultHead = null;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = 0;
            int y = 0;
            if (l1 != null) {
                x = l1.val;
            }
            if (l2 != null) {
                y = l2.val;
            }


            int c = x + y + carry;
            carry = 0;
            int toadd = 0;
            if (c >= 10) {
                carry = c/10;
                toadd = c%10;
            } else {
                toadd = c;
            }
            if (result == null) {
                result = new ListNode(toadd);
                resultHead = result;
            } else {
                ListNode temp = new ListNode(toadd);
                result.next = temp;
                result = result.next;
            }
            if (l1!= null && l1.next != null)
                l1 = l1.next;
            else
                l1 = null;

            if (l2!=null && l2.next != null)
                l2 = l2.next;
            else
                l2 = null;

        }

        return resultHead;
    }

    public void run() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode l3 = new ListNode(5, null);
        ListNode l4 = new ListNode(1, new ListNode(8, null));
        ListNode l5 = new ListNode(0, null);

        ListNode root = addTwoNumbers(l4, l5);

        while (root != null) {
            System.out.print(root.val + "\t");
            root = root.next;
        }

    }

    public static void main(String... args) {
        AddTwoNos addTwoNos = new AddTwoNos();
        addTwoNos.run();
    }
}
