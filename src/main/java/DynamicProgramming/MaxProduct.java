package DynamicProgramming;

import Base.BaseExecutor;

public class MaxProduct implements BaseExecutor {


    int minProduct;
    int maxProduct;

    public int maxProduct(int[] nums) {
        // Iterate over the array while maintaining min and max product variables

        int result = nums[0];
        minProduct = nums[0];
        maxProduct = nums[0];

        for(int i = 1; i < nums.length; i++){

            if(nums[i] < 0) {
                swap();
            }

            minProduct = Math.min(nums[i] * minProduct, nums[i]);
            maxProduct = Math.max(nums[i] * maxProduct, nums[i]);

            result = Math.max(result, maxProduct);
        }

        return result;
    }

    void swap() {
        int temp = minProduct;
        minProduct = maxProduct;
        maxProduct = temp;
    }

    @Override
    public void execute() {
        int[] arr1 = {2,3,4,-2,-4}; // 4,24   -48,-2   8,192
        int[] arr2 = {-2,0,-1};
        System.out.println(maxProduct(arr1));
        System.out.println(maxProduct(arr2));
    }

    public static void main(String[] args) {
        new MaxProduct().execute();
    }
}
