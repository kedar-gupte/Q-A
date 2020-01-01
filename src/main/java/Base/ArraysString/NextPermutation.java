package Base.ArraysString;

import Base.BaseExecutor;

import java.util.Arrays;

/**
 * Next Permutation
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3050/
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5,7,6,2 → 1,1,6,2,5,7
 *
 */
public class NextPermutation implements BaseExecutor {

    public void nextPermutation(int[] nums) {

        // Challenge here is to find the swap that has lower value than a number existing from end till that point
        // Iterating from an index and going lower will give Incorrect result

        // (_x) (i) .. (_y) .. (nums.length-1)

        int i = nums.length - 1;
        while(i > 0 && nums[i - 1] > nums[i]) {
            i--;
        }

        int _x = i - 1;

        int _y = nums.length - 1;
        while(_x > 0 && nums[_x] > nums[_y]) {
            _y--;
        }

        System.out.println("Indexes to Swap => [_x] : " + _x + " [i] : " + i + " [_y] : " + _y);

        // Swap the position where vaue is lower
        if(_x > 0) {
            swap(_x, _y, nums);
        }

        // Reverse the string from ith position to end of the string. This works because from i to j order is descending
        int j = nums.length - 1;
        while(i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }

    }

    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Override
    public void execute() {

        int[] nums_1 = {1, 2, 3};
        int[] nums_2 = {3, 2, 1};
        int[] nums_3 = {1, 1, 5, 7, 6, 2};

        nextPermutation(nums_1);
        System.out.println(Arrays.toString(nums_1));
        nextPermutation(nums_2);
        System.out.println(Arrays.toString(nums_2));
        nextPermutation(nums_3);
        System.out.println(Arrays.toString(nums_3));

    }

    public static void main(String[] args) {

        new NextPermutation().execute();

    }
}
