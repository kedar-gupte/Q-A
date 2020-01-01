package Base.ArraysString;

import Base.BaseExecutor;

import java.util.Arrays;

/**
 * Jump Game
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3053/
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 */
public class JumpGame implements BaseExecutor {

    public boolean canJump(int[] nums) {

        return canJumpIterative(nums);

    }

    boolean canJumpRecursive(int[] nums, int index) {

        System.out.println(index + " " + nums[index] + " " +  nums.length);

        if(index >= nums.length) {
            return false;
        }

        if(index == nums.length - 1) {
            return true;
        }

        for(int i = nums[index]; i >= 1; i--) {
            if(canJumpRecursive(nums, index + i))
                return true;
        }

        return false;
    }

    // O(n^2)
    boolean canJumpDP(int[] nums) {

        int[] feasible = new int[nums.length];
        Arrays.fill(feasible, 0);

        feasible[nums.length - 1] = 1;

        for(int i = nums.length - 2; i >= 0; i--) {

            for(int j = nums[i]; j >= 1; j--) {
                if(i + j < nums.length && feasible[i + j] == 1) {
                    feasible[i] = 1;
                    break;
                }
            }

        }

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(feasible));

        return feasible[0] == 1;

    }

    // O(n)
    boolean canJumpIterative(int[] nums) {

        int lastPosition = nums.length - 1;

        for(int i = nums.length - 1; i >= 0; i--) {

            if(i + nums[i] >= lastPosition) {
                lastPosition = i;
            }

        }

        return lastPosition == 0;

    }

    @Override
    public void execute() {

        int[] num_1 = {2,3,1,1,4};
        int[] num_2 = {3,2,1,0,4};

        System.out.println(canJump(num_1));
        System.out.println(canJump(num_2));

    }

    public static void main(String[] args) {

        new JumpGame().execute();

    }
}
