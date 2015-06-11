package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne extends TestCase {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0)
            return new int[1];

        int[] result = new int[digits.length+1];
        int i = digits.length-1;
        int j = digits.length;
        int toadd = 1;
        while (i >= 0) {
            int temp = digits[i];
            int sum = temp + toadd;
            if (sum >= 10)
                toadd = sum - 9;
            else
                toadd = 0;
            result[j] = sum%10;
            i=i-1;
            j=j-1;
        }
        if (toadd > 0) {
            result[0] = toadd;
            return result;
        } else {
            int[] r = new int[digits.length];
            for (int f=1, l=0; f<result.length; f++, l++) {
                r[l] = result[f];
            }
            return r;
        }



    }

    public void testOne() {
        assertTrue(plusOne(new int[] {0}).equals(new int[]{1}));
    }
}
