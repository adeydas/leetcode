package ws.abhis.leetcode.java;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 https://abhi.im/leetcode-climbing-stairs/
 */
public class ClimbStairs extends TestCase {

    private int[][] matrix;

    public int climbStairs(int n) {
        int[][] matrix = new int[n][n];
        for (int i=0; i<matrix.length; i++)
            Arrays.fill(matrix[i], 0);

        this.matrix = matrix;

        return climbStairsDP(n);
    }

    private int climbStairsDP(int n) {
        if (n<=0)
            return 0;
        if (n==1 || n==2)
            return n;
        if (matrix[n-1][n-2] != 0) {
            return matrix[n - 1][n - 2];
        }
        else {
            int s = climbStairsDP(n - 1) + climbStairsDP(n -2);
            matrix[n-1][n-2] = s;
            return matrix[n-1][n-2];
        }
    }


}
