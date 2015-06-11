package ws.abhis.leetcode.java;

import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0)
            return result;

        Set<Integer> set = new TreeSet<>();
        for (int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i=0; i<nums.length; i++) {
            int diff = target-nums[i];
            if (set.contains(diff)) {
                int o = findIndex(diff, nums);
                if (o != i) {
                    result[1] = i + 1;
                    result[0] = o + 1;
                }
            }

        }

        return result;
    }

    private int findIndex(int num, int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == num)
                return i;
        }
        return -1;
    }

    public static void main(String... args) {
        int[] nums = {2, 7, 11, 15};

        TwoSum twoSum = new TwoSum();
        int[] target = twoSum.twoSum(nums, 9);
        System.out.println(target[0] + "\t" + target[1]);
    }
}
