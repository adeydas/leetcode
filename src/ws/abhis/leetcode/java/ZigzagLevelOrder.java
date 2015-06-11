package ws.abhis.leetcode.java;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * https://abhi.im/leetcode-zigzag-level-order-traversal/
 */
public class ZigzagLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 1;
        int nextLevel = 0;
        int levelCounter = 0;
        List<Integer> tempList = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode t = queue.remove();
            currentLevel = currentLevel - 1;
            tempList.add(t.val);
            if (t.left != null) {
                queue.add(t.left);
                nextLevel = nextLevel + 1;
            }
            if (t.right != null) {
                queue.add(t.right);
                nextLevel = nextLevel + 1;
            }
            if (currentLevel == 0) {
                currentLevel = nextLevel;
                nextLevel = 0;
                if (levelCounter % 2 == 0) {
                    result.add(tempList);
                } else {
                    Collections.reverse(tempList);
                    result.add(tempList);
                }
                tempList = new ArrayList<>();
                levelCounter = levelCounter + 1;
            }
        }
        return result;
    }

    public void run() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        one.left = two;
        one.right = three;
        two.right = five;
        three.right = four;
        four.right = six;

        List<List<Integer>> ret = zigzagLevelOrder(one);
        for (int i=0; i<ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }

    public static void main(String... args) {
        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        zigzagLevelOrder.run();
    }
}
