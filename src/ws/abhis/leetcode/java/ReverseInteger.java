package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */
public class ReverseInteger extends TestCase {
    public int reverse(int x) {
        int init = x;
        boolean isNegative = false;
        if (x < 0)
            isNegative = true;

        x = Math.abs(x);

        int result = 0;
        while (x > 0) {
            //if overflows, it will start from Integer.MIN_VALUE
            if (result * 10 / 10 != result)
                return 0;
            result = result *  10 + x % 10;
            x = x / 10;
        }


        if (isNegative)
            result *= -1;

        return result;
    }

    public void testOne() {
        assertTrue(reverse(123) == 321);
    }
    public void testTwo() {
        assertTrue(reverse(-123) == -321);
    }
    public void testThree() {
        assertTrue(reverse(1000000003) == 0);
    }
    public void testFour() {
        assertTrue(reverse(1) == 1);
    }
    public void testFive() {
        assertTrue(reverse(10) == 1);
    }
    public void testSix() {
        assertTrue(reverse(1534236469) == 0);
    }

}
