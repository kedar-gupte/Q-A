package SortingSearching;

import Base.BaseExecutor;

import java.util.Arrays;

/**
 * Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/3081/
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 */
public class FirstAndLastPosition implements BaseExecutor {

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        Arrays.fill(result, -1);

        if(nums == null || nums.length == 0) {
            return result;
        }

        int start = 0, end = nums.length;
        int position = -1;

        while(start < end) {
            int mid = (start + end)/2;
            if(nums[mid] == target) {
                position = mid;
                break;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid;
            }
        }

        if(position == -1) {
            return result;
        }

        int temp = position - 1;
        while(temp >= 0 && nums[temp] == target) {
            temp--;
        }
        result[0] = temp + 1;
        temp = position + 1;
        while(temp < nums.length && nums[temp] == target) {
            temp++;
        }
        result[1] = temp - 1;

        return result;
    }

    @Override
    public void execute() {

        int[] nums = {1, 3};
        System.out.println(Arrays.toString(searchRange(nums, 1)));

    }

    public static void main(String[] args) {

        new FirstAndLastPosition().execute();

    }
}
