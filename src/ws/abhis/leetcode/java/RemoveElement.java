package ws.abhis.leetcode.java;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;

        int length = nums.length;
        int i = 0;

        while (i<length) {
            if (nums[i] == val) {
                int temp = nums[i];
                nums[i] = nums[length-1];
                nums[length-1] = temp;
                length = length - 1;
            } else {
                i = i+1;
            }
        }



        return length;
    }
}
