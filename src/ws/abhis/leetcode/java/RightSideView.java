package ws.abhis.leetcode.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Abhishek on 5/11/2015.
 */
public class RightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ret = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode t = queue.remove();

                if (i==0)
                    ret.add(t.val);
                if (t.right != null)
                    queue.add(t.right);
                if (t.left != null)
                    queue.add(t.left);
            }
        }

        return ret;
    }

    public void run() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//        TreeNode five = new TreeNode(5);

        one.left = two;
        one.right = three;
//        two.right = five;
//        three.right = four;

        List<Integer> ret = rightSideView(one);
        for (int i=0; i<ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }

    public static void main(String... args) {
        RightSideView rightSideView = new RightSideView();
        rightSideView.run();
    }
}
