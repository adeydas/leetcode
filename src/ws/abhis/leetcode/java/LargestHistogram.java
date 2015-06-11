package ws.abhis.leetcode.java;

import java.util.Stack;

/**
 * https://abhi.im/leetcode-largest-rectange-in-a-histogram-and-trapping-rain-water/
 */
public class LargestHistogram {
    public int area(int[] heights) {
        int area = 0;

        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        stack.push(cur);
        ++cur;

        while (cur <heights.length) {

               while (!stack.isEmpty() && heights[cur] > heights[stack.peek()]) {
                   if (stack.isEmpty())
                       break;
                   int b = stack.pop();
                   int localArea = ( (cur - b) + 1 ) * (Math.min(heights[b], heights[cur]));
                   area = Math.max(area, localArea);
               }
            stack.push(cur);
            ++cur;

        }
        return area;
    }

    public static void main(String... args) {
        LargestHistogram largestHistogram = new LargestHistogram();
        System.out.println(largestHistogram.area(new int[] {2,1,5,6,2,3}));
    }
}
