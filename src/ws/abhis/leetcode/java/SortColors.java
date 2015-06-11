package ws.abhis.leetcode.java;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 Single pass soln: http://n00tc0d3r.blogspot.com/2013/06/sort-colors.html
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int i=0; i<nums.length; i++) {
            int j = nums[i];
            if (j == 0)
                red = red+1;
            if (j == 1)
                white = white + 1;
            if (j == 2)
                blue = blue + 1;
        }
        int tot = 0;
        for (int i=0; i<red; i++, tot++)
            nums[tot] = 0;
        for (int i=0; i<white; i++, tot++)
            nums[tot] = 1;
        for (int i=0; i<blue; i++, tot++)
            nums[tot] = 2;
    }
}
