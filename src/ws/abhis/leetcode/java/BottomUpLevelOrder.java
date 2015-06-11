package ws.abhis.leetcode.java;

import junit.framework.TestCase;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class BottomUpLevelOrder extends TestCase {

    /**
     * Traverse level by level and store in a stack. Pop the resultant stack and populate the returned LL
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<ArrayList<Integer>> finalStack = new Stack<>();

        queue.add(root);
        int last = 1;
        int current = 0;

        ArrayList<Integer> l = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            l.add(node.val);
            last = last - 1;
            if (node.left != null) {
                queue.add(node.left);
                current = current + 1;
            }
            if (node.right != null) {
                queue.add(node.right);
                current = current + 1;
            }

            if (last == 0) {
                last = current;
                current = 0;
                finalStack.push(l);
                l = new ArrayList<>();
            }
        }

        List<List<Integer>> ret = new ArrayList<>();
        while (!finalStack.isEmpty()) {
            ArrayList<Integer> a = finalStack.pop();
            ret.add(a);
        }

        return ret;
    }

    public void testOne() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two; one.right = three;

        List<List<Integer>> r = levelOrderBottom(one);
        List<List<Integer>> expected = new ArrayList<>();
        ArrayList<Integer> o = new ArrayList<>();
        o.add(2); o.add(3);
        expected.add(o);
        o = new ArrayList<>();
        o.add(1);
        expected.add(o);

        assertTrue(r.equals(expected));
    }
}
