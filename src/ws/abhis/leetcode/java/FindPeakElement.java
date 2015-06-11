package ws.abhis.leetcode.java;

/**
 *A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ? num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -?.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 https://abhi.im/leetcode-find-peak-element/
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 0;
        if (nums.length == 2)
            return nums[0] > nums[1] ? 0 : 1;

        int low = 0;
        int high = nums.length-1;

        return findPeakElement(nums, low, high);
    }

    private int findPeakElement(int[] nums, int low, int high) {

        int mid = low + (high-low)/2;

        if ( (mid == 0 || nums[mid-1] <= nums[mid]) && (mid == nums.length-1 || nums[mid+1] <= nums[mid]))
            return mid;
        else if (mid > 0 && nums[mid] < nums[mid-1])
            return findPeakElement(nums, low, mid-1);
        else
            return findPeakElement(nums, mid+1, high);
    }

    public static void main(String... args) {
        int[] nums = {3,4,3,2,1};
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(nums) );
    }
}
