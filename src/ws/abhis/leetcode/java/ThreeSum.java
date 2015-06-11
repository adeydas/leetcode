package ws.abhis.leetcode.java;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        Set<List<Integer>> check = new HashSet<>();

        for (int i=0; i<nums.length; i++) {
            int l = i+1;
            int r = nums.length-1;

            while (l<r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> l1 = new ArrayList<>();
                    l1.add(nums[i]); l1.add(nums[l]); l1.add(nums[r]);
                    if (!check.contains(l1)) {
                        ret.add(l1);
                        check.add(l1);
                    }
                    l++; r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return ret;
    }

    public static void main(String... args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[] {-2,0,1,1,2};
        List<List<Integer>> r = new ArrayList<>();
        r = threeSum.threeSum(nums);

        for (List<Integer> l : r) {
            for (int i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
