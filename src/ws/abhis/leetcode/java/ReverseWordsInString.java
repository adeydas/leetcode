package ws.abhis.leetcode.java;

import junit.framework.TestCase;

import java.util.Stack;

/**
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Clarification:
 What constitutes a word?
 A sequence of non-space characters constitutes a word.
 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.
 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInString extends TestCase {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;

        String result = "";

        Stack<Character> queue = new Stack<>();
        for (int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);

            if (c == ' ' && queue.isEmpty()) {
                continue;
            } else if (c == ' ' && !queue.isEmpty()) {
                String temp = "";
                while (!queue.isEmpty()) {
                    temp += queue.pop();
                }
                result += temp + " ";
            } else {
                queue.add(c);
            }
        }
        if (!queue.isEmpty()) {
            String temp = "";
            while (!queue.isEmpty()) {
                temp += queue.pop();
            }
            result += temp + " ";
        }

        if (result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }

    public void testOne() {
        assertTrue(reverseWords("the sky is blue").equals("blue is sky the"));
    }
    public void testTwo() {
        assertTrue(reverseWords(" ").equals(""));
    }
}
