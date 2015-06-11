package ws.abhis.leetcode.java;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class SquareRoot {
    //Using Newton's method.
    public int mySqrt(int c) {
        if (c < 0) return 0;
        double EPS = 1E-15;
        double t = c;
        while (Math.abs(t - c/t) > EPS*t)
            t = (c/t + t) / 2.0;
        return (int)t;
    }

    public static void main(String... args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(squareRoot.mySqrt(26));
    }
}
