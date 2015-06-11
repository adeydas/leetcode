package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.


 */
public class Atoi extends TestCase {
    public int myAtoi(String str) {
        //If the string is of length 0 or null return 0
        if (str == null || str.length() == 0) {
            return 0;
        }

        //trim initial whitespaces
        int startIndex = 0;
        while (startIndex < str.length() && str.charAt(startIndex) == ' ') {
            startIndex = startIndex + 1;
        }


        boolean isNegative = false; //flag if the resultant number is negative

        if (str.charAt(startIndex) == '-') {
            isNegative = true;
            startIndex = startIndex+1;
        } else if (str.charAt(startIndex) == '+') {
            startIndex = startIndex+1;
        }

        int endIndex = startIndex;
        //find the end of the numeric sequence
        while (endIndex < str.length()-1 ) {
            if(charToNum(str.charAt(endIndex)) == -1) {
                endIndex = endIndex-1;
                break;
            }
            endIndex = endIndex + 1;
        }

        int result = 0;
        int div = 1;

        while (startIndex <= endIndex) {
            int i = charToNum(str.charAt(endIndex));

            if ((result * 10) / 10 != result)
                return result;

            result = result + (i * div);
            endIndex = endIndex-1;
            div = div * 10;
        }

        if (isNegative)
            result = result * -1;

        return result;

    }

    private int charToNum(char c) {
        int ret = -1;
        switch (c) {
            case '0': ret = 0; break;
            case '1': ret = 1; break;
            case '2': ret = 2; break;
            case '3': ret = 3; break;
            case '4': ret = 4; break;
            case '5': ret = 5; break;
            case '6': ret = 6; break;
            case '7': ret = 7; break;
            case '8': ret = 8; break;
            case '9': ret = 9; break;
            default: ret = -1; break;
        }
        return ret;
    }

    public void testOne() {
        assertTrue(myAtoi(" 12**1") == 12);
    }
    public void testTwo() {
        assertTrue(myAtoi("1") == 1);
    }
    public void testThree() {
        assertTrue(myAtoi("+1") == 1);
    }
    public void testFour() {
        assertTrue(myAtoi("   -04f") == -4);
    }
}
