package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeros extends TestCase {

    //keep on dividing by k till k is smaller.
    public int trailingZeroes(int n) {
        int count = 0;
        long k = 5;
        while(n >= k)
        {
            count+=n/k;
            k*=5;
        }
        return count;
    }

    public void testOne() {
        assertTrue(trailingZeroes(10) == 2);
    }
    public void testTwo() {
        assertTrue(trailingZeroes(30) == 7);
    }
}
