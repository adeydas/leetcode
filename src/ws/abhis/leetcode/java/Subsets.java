package ws.abhis.leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *https://leetcode.com/problems/subsets/
 * https://abhi.im/leetcode-find-all-possible-subsets/
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return null;

        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            int focus = nums[i];
            List<Integer> f = new ArrayList<>();
            f.add(focus);
            ret.add(f);

            int j=0;
            List<List<Integer>> tempInt = new ArrayList<>();
            while (j<ret.size()-1) {
                List<Integer> temp = ret.get(j);
                ArrayList<Integer> temp2 = (ArrayList<Integer>) ((ArrayList)temp).clone();
                temp2.add(focus);
//                Collections.sort(temp2);
                tempInt.add(temp2);
                j=j+1;
            }
            ret.addAll(tempInt);
        }

        //Empty set
        List<Integer> empty = new ArrayList<>();
        ret.add(empty);

        return ret;
    }

    public static void main(String... args) {
        int[] nums = {4,1,0};
        Subsets subsets = new Subsets();
        List<List<Integer>> ret = subsets.subsets(nums);

        for (int i=0; i<ret.size(); i++) {
            List<Integer> temp = ret.get(i);
            for (int j=0; j<temp.size(); j++) {
                System.out.print(temp.get(j) + "\t");
            }
            System.out.println();
        }
    }
}
