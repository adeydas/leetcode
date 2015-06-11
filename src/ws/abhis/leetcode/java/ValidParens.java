package ws.abhis.leetcode.java;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParens {
    public boolean isValid(String s) {
        if (s==null || s.length() == 0)
            return true;

        Stack<Character> pa = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || c==']' || c=='}') {
                if (pa.isEmpty())
                    return false;
                char p = pa.pop();
                if (c == ')') {
                    if (p != '(')
                        return false;
                }
                if (c == ']') {
                    if (p != '[')
                        return false;
                }
                if (c == '}') {
                    if (p != '{')
                        return false;
                }
            } else {
                pa.push(c);
            }
        }
        if (pa.isEmpty())
            return true;
        else
            return false;
    }

    public static void main (String... args) {
        String s = "([)]";
        ValidParens validParens = new ValidParens();
        System.out.println(validParens.isValid(s));
    }
}
