package ArraysString;

import Base.BaseExecutor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Single number
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/549/
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 *
 */
public class SingleNumber implements BaseExecutor {

    public int singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int x : nums) {
            if(set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }

        return new ArrayList<>(set).get(0);

    }

    /*
    Concept

        If we take XOR of zero and some bit, it will return that bit
        a xor 0 = a
        If we take XOR of two same bits, it will return 0
        a xor a = 0
        a xor b xor a = (a xor a) xor b = 0 xor b = b
        So we can XOR all bits together to find the unique number.
     */
    public int singleNumberConstantSpace(int[] nums) {

        int result = 0;

        for(int x : nums) {
            result ^= x;
        }

        return result;

    }

    @Override
    public void execute() {

        int[] nums = {2,4,1,2,1};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumberConstantSpace(nums));

    }

    public static void main(String[] args) {

        new SingleNumber().execute();

    }
}
