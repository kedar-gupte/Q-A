package DynamicProgramming;

import Base.BaseExecutor;

import java.util.Arrays;

public class TimeToBuyStock implements BaseExecutor {

    public int maxProfit(int[] prices) {

        int result = 0;
        if(prices == null || prices.length <= 1) {
            return result;
        }

        int[] minPrices = new int[prices.length];
        int[] maxPrices = new int[prices.length];

        int min = prices[0];
        minPrices[0] = prices[0];
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            minPrices[i] = min;
        }

        int max = prices[prices.length - 1];
        maxPrices[prices.length - 1] = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxPrices[i] = max;
        }

        System.out.println(Arrays.toString(minPrices));
        System.out.println(Arrays.toString(maxPrices));

        for(int i = 0; i < prices.length - 1; i++) {
            result = Math.max(result, maxPrices[i] - minPrices[i]);
        }

        return result;
    }

    @Override
    public void execute() {
        int[] arr1 = {7,1,5,3,6,4};
        int[] arr2 = {5,4,3,2};
        System.out.println(maxProfit(arr1));
        System.out.println(maxProfit(arr2));
    }

    public static void main(String[] args) {
        new TimeToBuyStock().execute();
    }
}
