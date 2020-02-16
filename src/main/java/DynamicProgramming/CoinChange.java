package DynamicProgramming;

import Base.BaseExecutor;

/**
 * Coin change problem
 * https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/3088/
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 */

public class CoinChange implements BaseExecutor {

    public int coinChange(int[] coins, int amount) {

        int[] minCoins = new int[amount + 1];
        minCoins[0] = 0;

        for(int i = 1; i <= amount; i++) {

            int minimum = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(i >= coin) {
                    minimum = Math.min(minimum, 1 + minCoins[i - coin]);
                }
            }

            minCoins[i] = (minimum != Integer.MAX_VALUE) ? minimum : -1 ;

        }

        return minCoins[amount];
    }

    @Override
    public void execute() {
        int[] coins1 = {1,2,5};
        System.out.println(coinChange(coins1, 11));
        int[] coins2 = {1,10,25};
        System.out.println(coinChange(coins2, 33));
    }

    public static void main(String[] args) {
        new CoinChange().execute();
    }
}
