package ArraysString;

import Base.BaseExecutor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/interview/card/uber/289/array-and-string/1682/
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum implements BaseExecutor {

    int[] twoSum(int[] nums, int target) {

        int[] result = {-1, - 1};

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {

            if(map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            }

            int complement = target - nums[i];
            map.put(complement, i);
        }

        return result;

    }

    @Override
    public void execute() {

        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 18)));

    }

    public static void main(String[] args) {
        new TwoSum().execute();
    }
}
