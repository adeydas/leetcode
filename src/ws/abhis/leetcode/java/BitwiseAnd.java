package ws.abhis.leetcode.java;

/**
 * Created by Abhishek on 5/11/2015.
 */
public class BitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        if (m == n)
            return m;
        if (n == m+1)
            return m&n;

        while (m <= n) {
            if (result == 0) {
                int k = m + 1;
                result = m & k;
                m = m + 2;
            } else {
                result = result & m;
                m = m +1;
            }
        }
        return result;
    }

    public static void main(String... args) {
        BitwiseAnd bitwiseAnd = new BitwiseAnd();
        System.out.println(bitwiseAnd.rangeBitwiseAnd(5,7));
    }
}
