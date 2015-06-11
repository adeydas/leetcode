package ws.abhis.leetcode.java;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 https://abhi.im/leetcode-find-the-majority-element/
 */
public class MajorityElement extends TestCase {
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement(int[] nums) {
        int count = 1;
        int majorityIndex = 0;

        //Find a majority candidate
        for (int i=0; i<nums.length; i++) {
            if (nums[majorityIndex] == nums[i])
                count = count + 1;
            else
                count = count - 1;

            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }

        //Check if the majority candidate is really the majority element
        int count2 = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == nums[majorityIndex])
                count2 = count2 + 1;
        }

        if (count2 >= nums.length/2)
            return nums[majorityIndex];
        else
            return -1;

    }

    public void testOne() {
        assertTrue(majorityElement(new int[]{4, 1, 4}) == 4);
    }


}
