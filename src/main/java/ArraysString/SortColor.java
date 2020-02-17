package ArraysString;

import Base.BaseExecutor;

import java.util.Arrays;

public class SortColor implements BaseExecutor {

    public void sortColors(int[] nums) {

        int start = 0, end = nums.length - 1, i = 0;

        while(i <= end) {

            if(nums[i] == 0) {
                swap(nums, i++, start++);
            } else if(nums[i] == 2) {
                swap(nums, i, end--);
            } else {
                i++;
            }

        }

    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Override
    public void execute() {
        int[] arr1 = {0,1,2,0,1,2};
        sortColors(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void main(String[] args) {
        new SortColor().execute();
    }
}
