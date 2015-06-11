package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 */
public class LengthLastWord extends TestCase {
    public int lengthOfLastWord(String s) {
        if (s.contains(" ") && s.length() == 1)
            return 0;
        String[] sp = s.split(" ");
        if (sp.length == 0)
            return 0;
        String p = sp[sp.length-1];
        if (p== " ")
            return 0;
        else
            return p.length();
    }

    public void testOne() {
        assertTrue(lengthOfLastWord("        ") == 0);
    }

    public void testTwo() {
        assertTrue(lengthOfLastWord("a") == 1);
    }
}
