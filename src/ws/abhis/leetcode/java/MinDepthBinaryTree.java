package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinDepthBinaryTree extends TestCase {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right == null)
            return minDepth(root.left) + 1;
        else if (root.right != null && root.left == null)
            return minDepth(root.right) + 1;
        else
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;


    }

    public void testOne() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        one.left = two;
        assertTrue(minDepth(one) == 2);
    }
}
