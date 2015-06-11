package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class ExcelSheetColTitle extends TestCase {
    public String convertToTitle(int n) {
        if (n <= 0)
            return "";

        String ret = "";

        while (n > 0) {
            n--;
            char c = (char) (n % 26 + 'A');
            n = n/26;
            ret = String.valueOf(c) + ret;
        }

        return ret;
    }

    public void testOne() {
        assertTrue(convertToTitle(26).equals("Z"));
    }
    public void testTwo() {
        assertTrue(convertToTitle(28).equals("AB"));
    }
}
