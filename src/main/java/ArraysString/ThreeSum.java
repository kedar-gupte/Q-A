package ArraysString;

import Base.BaseExecutor;

import java.util.*;

public class ThreeSum implements BaseExecutor {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        int i = 0;

        while(i < nums.length) {

            int first = nums[i];

            int target = -1 * first;

            int x = i+1, y = nums.length - 1;

            while(x < y) {

                //System.out.println(first + " " + nums[x] + " " + nums[y]);

                if((nums[x] + nums[y]) == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(first);
                    temp.add(nums[x]);
                    temp.add(nums[y]);
                    list.add(temp);
                }

                if((nums[x] + nums[y]) <= target) {
                    while(x < y && nums[x] == nums[x + 1])
                        x++;
                    x++;
                } else {
                    while(x < y && nums[y] == nums[y - 1])
                        y--;
                    y--;
                }

                //System.out.println(x + " " + y);
            }

            while(i < nums.length - 1 && nums[i] == nums[i+1])
                i++;

            i++;
        }

        return list;

    }

    @Override
    public void execute() {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(nums);
        list.forEach(e -> {
            System.out.println(e);
        });
    }

    public static void main(String[] args) {
        new ThreeSum().execute();
    }
}
