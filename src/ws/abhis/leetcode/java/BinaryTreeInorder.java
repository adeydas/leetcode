package ws.abhis.leetcode.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        boolean finished = false;

        List<Integer> list = new ArrayList<>();

        while (!finished) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                list.add(t.val);
                curr = t.right;
            } else {
                finished = true;
            }
        }

        return list;
    }

    public void run() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        one.right = two;
        two.left = three;

        inorderTraversal(one);
    }

    public static void main(String... args) {
        BinaryTreeInorder binaryTreeInorder = new BinaryTreeInorder();
        binaryTreeInorder.run();
    }
}
