package ws.abhis.leetcode.java;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s==null || s.length()==0)
            return true;

        s = s.toLowerCase();
        int i=0, j=s.length()-1;

        while (i < j) {
            boolean go = true;
            if ( !((s.charAt(i) >=48 && s.charAt(i) <= 57) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)) ) {
                i++;
                go = false;
            }
            if ( !((s.charAt(j) >=48 && s.charAt(j) <= 57) || (s.charAt(j) >= 97 && s.charAt(j) <= 122)) ) {
                j--;
                go = false;
            }
            if (go && s.charAt(i) != s.charAt(j)) {
                return false;
            }
            if (go) {
                i++; j--;
            }
        }

        return true;
    }

    public static void main(String... args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("race a car"));
    }
}
