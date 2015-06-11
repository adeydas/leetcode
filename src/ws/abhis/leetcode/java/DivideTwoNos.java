package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 */
public class DivideTwoNos extends TestCase {
    public int divide(int dividend, int divisor) {
        int cnt = 0;
        boolean dividendN = false, divisorN = false;
        if (dividend < 0) {
            dividendN = true;
            dividend *= -1;
        }
        if (divisor < 0) {
            divisorN = true;
            divisor *= -1;
        }
        while (dividend >= divisor) {
            dividend -= divisor;
            cnt = cnt+1;
        }
        if ( (dividendN && !divisorN) || (!dividendN && divisorN) )
            cnt *= -1;
        return cnt;
    }

    public void testOne() {
        assertTrue(divide(5, 2) == 2);
    }
    public void testTwo() {
        assertTrue(divide(1, -1) == -1);
    }
    public void testThree() {
        assertTrue(divide(2147483647, 1) == 2147483647);
    }
}
