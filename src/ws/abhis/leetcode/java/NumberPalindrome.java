package ws.abhis.leetcode.java;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.


 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.
 */
public class NumberPalindrome {
    public boolean isPalindrome(int x) {
        //-ve numbers are not palindromes
        if (x < 0)
            return false;
        //Find the divisor till which quotient is greater than 10
        int d = 1;
        while (x/d >= 10)
            d *= 10;

        //Start from both ends, compare and reject if unequal
        while (x != 0) {
            int l = x/d;
            int r = x%10;
            if (l!=r)
                return false;
            // divide by 10 to shed the right most integer
            // mod by d to shed the left most integer
            // reduce d by 2 places aka divide by 100
            x = (x%d) / 10;
            d /= 100;
        }

        return true;
    }
}
