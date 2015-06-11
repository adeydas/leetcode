package ws.abhis.leetcode.java;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber extends TestCase {

    public boolean isAllZeros(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0)
                return false;
        }
        return true;
    }

    public String largestNumber(int[] nums) {
        if (isAllZeros(nums))
            return "0";

        String[] s = new String[nums.length];

        for (int i=0; i<nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s, comparator);

        String ret = "";

        for (int i=s.length-1; i>=0; i--) {
            ret += s[i];
        }

        return ret;
    }

    public Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            String combinationOne = o1 + o2;
            String combinationTwo = o2 + o1;

            return combinationOne.compareTo(combinationTwo);
        }
    };

    public void testOne() {
        int[] n = {3, 30, 34, 5, 9};
        assertTrue(largestNumber(n).equals("9534330"));
    }
}
