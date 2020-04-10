package DynamicProgramming;

import Base.BaseExecutor;

import java.util.Arrays;

public class JumpGame implements BaseExecutor {

    public boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[nums.length - 1] = true;

        for(int i = nums.length - 2; i >= 0; i--) {

            for(int j = 0; j < nums[i] && j < nums.length; j++) {
                if(dp[i + j + 1]) {
                    dp[i] = true;
                    break;
                }
            }

        }

        return dp[0];

    }

    @Override
    public void execute() {

        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));

    }

    public static void main(String[] args) {
        new JumpGame().execute();
    }
}
