package ws.abhis.leetcode.java;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * https://abhi.im/leetcode-find-the-container-with-most-water/
 */
public class Container {

    //Greedy method.
    public int maxArea(int[] height) {
        if (height.length == 0)
            return 0;

        int low = 0, high = height.length-1;
        int maxArea = 0;

        while (low < high) {
            maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high])
                low++;
            else
                high--;
        }

        return maxArea;
    }

    //Naive method.
    public int maxArea2(int[] height) {
        if (height.length == 0)
            return 0;


        int maxArea = Integer.MIN_VALUE;

        for (int i=1; i<height.length; i++) {

            for (int j=0; j<i; j++) {
                int diff = height[i] - height[j];
                if (diff == 0)
                    diff = height[i];
                int ma = (i-j) * diff;
                maxArea = Math.max(maxArea, ma);
            }

        }

        return maxArea;
    }

    public static void main(String... args) {
        int[] height = {1,2,4,3};
        Container container = new Container();
        System.out.println(container.maxArea(height));
    }
}
