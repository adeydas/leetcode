package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSizeSubarrSum extends TestCase {
    public int minSubArrayLen(int s, int[] nums) {
        int low = 0, high = 0, sum = 0, minLength = Integer.MAX_VALUE;

        while (low < nums.length) {
            if (sum >= s) {
                minLength = Math.min(minLength, high-low);
                sum -= nums[low++];
            } else {
                if (high >= nums.length)
                    break;
                sum += nums[high++];
            }

        }


        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public void testOne() {
        int[] i = new int[]{2,3,1,2,4,3};
        assertTrue(minSubArrayLen(7, i) == 2);
    }
}
