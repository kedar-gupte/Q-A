package SortingSearching;

import Base.BaseExecutor;

public class MaximumSubarray implements BaseExecutor {

    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
            if(sum < 0) {
                sum = 0;
            }

        }

        return maxSum;

    }

    @Override
    public void execute() {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }

    public static void main(String[] args) {

        new MaximumSubarray().execute();
        
    }
}
