package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class SearchForRange extends TestCase {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int tar = -1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] == target) {
                tar = mid;
                break;
            }
            if (nums[mid] > target) {
                high = mid-1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        if (tar == -1) {
            return new int[] {-1,-1};
        }

        int start = tar, end = tar;
        while (start >= 0 && nums[start] == target ) {
            start = start-1;
        }
        start = start+1;
        while (end < nums.length && nums[end] == target ) {
            end = end + 1;
        }
        end = end-1;

        return new int[] {start, end};
    }

    public void testOne(){
        int[] i = new int[] {5, 7, 7, 8, 8, 10};
        int[] a = new int[] {3, 4};
        assertTrue(searchRange(i, 8).equals(a));
    }
}
