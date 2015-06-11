package ws.abhis.leetcode.java;


/**
 *Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return findHeight(root) >= 0;
    }

    /**
     * Check if height difference honors property of a balanced tree. If not, return -1, else height
     * @param root
     * @return
     */
    private int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if (left <0 || right <0 || Math.abs(left - right) > 1)
            return -1;
        else
            return Math.max(left, right) + 1;
    }

}
