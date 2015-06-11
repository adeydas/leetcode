package ws.abhis.leetcode.java;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * https://abhi.im/leetcode-validate-a-binary-search-tree/
 */
public class ValidBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x, TreeNode left, TreeNode right) { val = x; this.left = left; this.right = right; }
    }

    public boolean isValidBST(TreeNode root) {

        inOrder(root);
        for (int i=1; i<vals.size(); i++) {
            if (vals.get(i-1) >= vals.get(i))
                return false;
        }

        return true;
    }

    List<Integer> vals = new LinkedList<Integer>();

    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        vals.add(root.val);
        inOrder(root.right);
    }

    public void run() {
        //TreeNode treeNode = new TreeNode(10, new TreeNode(5, null, null), new TreeNode(15, new TreeNode(6, null, null), new TreeNode(20, null, null)));
        TreeNode treeNode = new TreeNode(0, new TreeNode(-1, null, null), null);
        System.out.println(isValidBST(treeNode));
    }

    public static void main(String... args) {
        ValidBST validBST = new ValidBST();
        validBST.run();
    }
}
