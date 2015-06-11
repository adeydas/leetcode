package ws.abhis.leetcode.java;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KLargetElement {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) {
            k = k%nums.length;
        }
        Arrays.sort(nums);
        int kIndex = nums.length-k;
        return nums[kIndex];
    }
}
