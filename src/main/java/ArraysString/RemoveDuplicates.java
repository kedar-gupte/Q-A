package ArraysString;

import Base.BaseExecutor;

import java.util.Arrays;

/**
 * Remove duplicates from sorted array
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 */
public class RemoveDuplicates implements BaseExecutor {

    public int removeDuplicates(int[] nums) {
        int prev = 0, index = 1;

        if(nums == null || nums.length <= 1) {
            return nums.length;
        }

        while(index < nums.length) {

            while(index < nums.length && nums[prev] == nums[index]) {
                index++;
            }

            prev++;

            if(index < nums.length) {
                nums[prev] = nums[index];
            }

        }

        return prev;
    }

    @Override
    public void execute() {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        new RemoveDuplicates().execute();
    }
}
