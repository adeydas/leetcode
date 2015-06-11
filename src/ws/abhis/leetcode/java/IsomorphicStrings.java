package ws.abhis.leetcode.java;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 */
public class IsomorphicStrings extends TestCase {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0)
            return true;

        return isIsomorphicOneSide(s,t) && isIsomorphicOneSide(t,s);


    }

    private boolean isIsomorphicOneSide(String s, String t) {
        char[] mp = new char[256];
        Arrays.fill(mp, '*');
        for (int i=0; i<s.length(); i++) {
            int index = (int)s.charAt(i);
            if (mp[index] == '*') {
                mp[index] = t.charAt(i);
            } else {
                if (mp[index] != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }



    public void testOne() {
        assertTrue(isIsomorphic("egg", "add"));
    }
    public void testTwo() {
        assertTrue(!isIsomorphic("foo", "bar"));
    }
    public void testThree() {
        assertTrue(isIsomorphic("paper", "title"));
    }
}
