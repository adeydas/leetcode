package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class Search2DMatrix extends TestCase {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 1) {
            for (int i=0; i<matrix[0].length; i++) {
                if (matrix[0][i] == target)
                    return true;
            }
            return false;
        }

        for (int i=1; i<matrix.length; i++) {
            if ( target > matrix[i-1][matrix[0].length-1] && target <= matrix[i][matrix[0].length-1] ) {
                int[] nums = new int[matrix[i].length];
                for (int j=0; j<matrix[i].length; j++) {
                    nums[j] = matrix[i][j];
                }
                return binarySearch(nums, target);
            } else if (target <= matrix[i-1][matrix[0].length-1]) {
                int[] nums = new int[matrix[i].length];
                for (int j=0; j<matrix[i-1].length; j++) {
                    nums[j] = matrix[i-1][j];
                }
                return binarySearch(nums, target);
            }
        }

        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (target < nums[mid]) {
                high = mid-1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }

        return false;
    }

    public void testOne() {
        int[][] matrix = new int[1][1];
        matrix[0][0] = 1;
        assertTrue(searchMatrix(matrix,1));
    }
    public void testTwo() {
        int[][] matrix = new int[2][1];
        matrix[0][0] = 1;
        matrix[1][0] = 3;
        assertTrue(searchMatrix(matrix,1));
    }
    public void testThree() {
        int[][] matrix = new int[2][1];
        matrix[0][0] = 1;
        matrix[1][0] = 3;
        assertTrue(searchMatrix(matrix,3));
    }
}
