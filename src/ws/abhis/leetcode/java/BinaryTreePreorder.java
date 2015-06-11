package ws.abhis.leetcode.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);
        List<Integer> ret = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            ret.add(t.val);
            if (t.right != null)
                stack.push(t.right);
            if (t.left != null)
                stack.push(t.left);
        }

        return ret;
    }

    public void run() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        one.right = two;
        two.left = three;

        preorderTraversal(one);
    }

    public static void main(String... args) {
        BinaryTreePreorder binaryTreeInorder = new BinaryTreePreorder();
        binaryTreeInorder.run();
    }

}
