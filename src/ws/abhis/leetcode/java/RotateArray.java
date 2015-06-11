package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 https://abhi.im/leetcode-rotate-array/
 */
public class RotateArray extends TestCase {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0)
            return;
        if (k > nums.length)
            k=k%nums.length;

        rotate(nums, 0, nums.length-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length-1);

    }

    private void rotate(int[] nums, int low, int high) {
        if (nums == null || nums.length == 1)
            return;

        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++; high--;
        }
    }

    public void testOne() {
        int[] nums = new int[] {1,2};
        rotate(nums,3);
    }
}
