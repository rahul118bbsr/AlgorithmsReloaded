package mishra.dev.rahul.array;

import java.util.Arrays;

/**
 * https://www.interviewcake.com/question/python/merge-sorted-arrays
 * <p>
 * Created by aleesha on 19/08/17.
 */
public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 6, 10, 11, 15};
        int[] arr2 = {1, 5, 8, 12, 14, 19};
        int[] mergedArr = mergeSortedArrays(arr1, arr2);
        Arrays.stream(mergedArr).forEach(i -> System.out.print(i + " "));
    }

    private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return arr2;
        }

        if (arr2 == null || arr2.length == 0) {
            return arr1;
        }
        int[] mergedArr = new int[arr1.length + arr2.length];
        int ptr1 = 0, ptr2 = 0, mergedArrPtr = 0;
        while (ptr1 < arr1.length || ptr2 < arr2.length) {
            if (ptr2 >= arr2.length || (ptr1 < arr1.length && arr1[ptr1] <= arr2[ptr2])) {
                mergedArr[mergedArrPtr] = arr1[ptr1];
                ptr1++;
            } else if (ptr1 >= arr1.length || (ptr2 < arr2.length && arr2[ptr2] <= arr1[ptr1])) {
                mergedArr[mergedArrPtr] = arr2[ptr2];
                ptr2++;
            }
            mergedArrPtr++;
        }
        return mergedArr;
    }
}
