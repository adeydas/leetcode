package ws.abhis.leetcode.java;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

 https://abhi.im/leetcode-merge-two-sorted-arrays/
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = m+n-1;
        m--; n--;
        //For the ith position starting from the end, store he large element of the two arrays, also starting from their respective ends.
        while (m>=0 && n>=0) {
            nums1[count--] = nums1[m]>nums2[n] ? nums1[m--] : nums2[n--];
        }
        // add the leftovers to the final array.
        while (n>=0)
            nums1[count--] = nums2[n--];
    }
}
