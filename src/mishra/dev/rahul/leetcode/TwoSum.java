package mishra.dev.rahul.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/#/description
 *
 * Created by aleesha on 24/07/17.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] result = twoSum(arr, 9);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.get(complement) != null && map.get(complement) != i) {
                result [0] = i;
                result[1] = map.get(complement);
                return result;
            }
        }
        return null;
    }
}
