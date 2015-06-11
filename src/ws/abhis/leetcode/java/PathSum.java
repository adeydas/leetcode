package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum extends TestCase {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        return hasPath(root, sum);
    }
    private boolean hasPath(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && (sum-root.val) == 0) { //if leaf and sum==0
            return true;
        }
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);

    }

    public void testOne() {
        TreeNode one = new TreeNode(1);
        assertTrue(hasPathSum(one, 1));
    }
    public void testTwo() {
        TreeNode two = null;
        assertTrue(!hasPathSum(two, 0));
    }
    public void testThree() {
        TreeNode one = new TreeNode(1);
        assertTrue(!hasPathSum(one, 0));
    }
    public void testFour() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        one.left = two;
        assertTrue(!hasPathSum(one, 1));
    }
}
