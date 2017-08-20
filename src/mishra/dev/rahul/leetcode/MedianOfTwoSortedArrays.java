package mishra.dev.rahul.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/#/description
 *
 * Created by aleesha on 24/07/17.
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {2, 4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, result, 0, nums1.length);
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
        Arrays.sort(result);
        if(result.length % 2 == 0) {
            int mid = result.length / 2;
            return (result[mid] + result[mid - 1]) / 2.0;
        } else {
            int mid = result.length / 2;
            return result[mid];
        }
    }
}
