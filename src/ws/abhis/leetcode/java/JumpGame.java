package ws.abhis.leetcode.java;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0)
                return true;

            int i=0;
            while (i<nums.length-1) {
                if (nums[i] == 0)
                    return false;
                i=i+nums[i]-1;
            }
            if (i == nums.length-1)
                return true;
            else
                return false;
        }

    public static void main(String... args) {
        int[] nums = {2,1};
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(nums));
    }
}
