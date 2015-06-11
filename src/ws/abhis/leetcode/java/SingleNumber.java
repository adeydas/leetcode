package ws.abhis.leetcode.java;

/**
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {

        int a = nums[0];

        for (int i=1; i<nums.length; i++) {
            a = a^nums[i];
        }
        return a;
    }

    public static void main(String... args) {
        int[] arr = {5,5, 1,1, 3, 6,6, 9,9, 10,10};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(arr));
    }
}
