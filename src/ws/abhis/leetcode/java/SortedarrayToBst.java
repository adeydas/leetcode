package ws.abhis.leetcode.java;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * https://abhi.im/leetcode-sorted-array-to-binary-search-tree/
 */
public class SortedarrayToBst {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        if (nums.length == 1)
            return new TreeNode(nums[0]);

        int low = 0;
        int high = nums.length-1;

        return sortedArrayToBST(nums, low, high);
    }

    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            TreeNode parent = new TreeNode(nums[mid]);
            parent.left = sortedArrayToBST(nums, low, mid - 1);
            parent.right = sortedArrayToBST(nums, mid + 1, high);
            return parent;
        } else {
            return null;
        }
    }

    public void run() {
        int[] nums = {1,3};

        TreeNode t = sortedArrayToBST(nums);
        inOrder(t);
    }

    private void inOrder(TreeNode t) {
        if (t==null)
            return;
        inOrder(t.left);
        System.out.println(t.val);
        inOrder(t.right);
    }

    public static void main(String... args) {
        SortedarrayToBst sortedarrayToBst = new SortedarrayToBst();
        sortedarrayToBst.run();
    }
}
