package ws.abhis.leetcode.java;

import java.util.Stack;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * https://abhi.im/leetcode-largest-rectange-in-a-histogram-and-trapping-rain-water/
 */
public class TrapRainWater {
    public int trap(int[] height) {

        //skip zeros
        int cur = 0;
        while (cur < height.length && height[cur] == 0)
            ++cur;

        int volume = 0;
        Stack<Integer> stack = new Stack<>();
        while (cur < height.length) {
            while (!stack.isEmpty() && height[cur] >= height[stack.peek()] ) {
                int b = stack.pop();
                if (stack.isEmpty())
                    break;
                volume += ((cur - stack.peek()-1) * (Math.min(height[cur], height[stack.peek()]) - height[b]));
            }
            stack.push(cur);
            ++cur;
        }
        return volume;
    }

    public static void main(String... args) {
        TrapRainWater trapRainWater = new TrapRainWater();
        System.out.println(trapRainWater.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
