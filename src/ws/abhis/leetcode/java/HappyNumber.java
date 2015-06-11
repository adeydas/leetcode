package ws.abhis.leetcode.java;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1

 */
public class HappyNumber extends TestCase {

    /**
     * If the number is un-happy, it will result in a cycle, aka, repetition.
     * If happy, in 1.
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();

        boolean done = false;
        while (!done) {

            if (s.contains(n))
                return false;

            s.add(n);

            if (n == 1) {
                done = true;
                continue;
            }

            int sum = 0;
            while (n > 0) {
                int m = n%10;
                sum += Math.pow(m,2);
                n /= 10;
            }

            n = sum;

        }

        return true;
    }

    public void testOne() {
        assertTrue(isHappy(19));
    }
    public void testTwo() {
        assertTrue(!isHappy(20));
    }
}
