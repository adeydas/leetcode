package ws.abhis.leetcode.java;

import java.util.Arrays;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class MinRotatedSortedArr {
    public int findMin(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.min(nums[0], nums[1]);

        if (nums[0] < nums[nums.length-1]) {
            return nums[0];
        }
        int mid = nums.length/2;
        if (nums[mid] > nums[0]) {
            return findMin(Arrays.copyOfRange(nums, mid+1, nums.length));
        } else {
            return findMin(Arrays.copyOfRange(nums, 0, mid+1));
        }
    }

    public static void main(String... args) {
        int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        MinRotatedSortedArr minRotatedSortedArr = new MinRotatedSortedArr();
        System.out.println(minRotatedSortedArr.findMin(nums));
    }
}
