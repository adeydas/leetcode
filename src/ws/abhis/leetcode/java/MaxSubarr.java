package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [?2,1,?3,4,?1,2,1,?5,4],
 the contiguous subarray [4,?1,2,1] has the largest sum = 6.
 */
public class MaxSubarr extends TestCase {
    //Kadane algo
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int n : nums) {
            sum += n;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) sum = 0; // reset the current sum
        }
        return maxSum;
    }

    public void testOne() {
        int[] i = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        assertTrue(maxSubArray(i) == 6);
    }
}
