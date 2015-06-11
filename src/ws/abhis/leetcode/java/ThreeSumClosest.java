package ws.abhis.leetcode.java;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 * https://abhi.im/3sum-closest/
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int closestSum = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++) {
            int l=i+1;
            int r=nums.length-1;

            while (l < r) {
                int s = nums[i] + nums[l] + nums[r];
                if (Math.abs(target-s) < diff) {
                    closestSum = s;
                    diff = Math.abs(target-s);
                }
                if (s < target)
                    l++;
                else
                    r--;
            }
        }

        return closestSum;
    }

    public static void main(String... args) {
        int[] nums = {-1, 2, 1, -4};
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(nums, 1));
    }

}
