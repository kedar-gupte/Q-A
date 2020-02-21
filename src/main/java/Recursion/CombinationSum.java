package Recursion;

import Base.BaseExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum implements BaseExecutor {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, 0, target, result, new ArrayList<>());
        return result;

    }

    void combinationSum(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> temp) {

        if(target < 0) {
            return;
        } else if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        } else {
            for(int i = index; i < candidates.length; i++) {
                temp.add(candidates[i]);
                combinationSum(candidates, i, target - candidates[i], result, temp);
                temp.remove(temp.size() - 1);
            }
        }


    }

    @Override
    public void execute() {
        int[] nums = {2,3,6,7};
        System.out.println(combinationSum(nums, 7));
    }

    public static void main(String[] args) {
        new CombinationSum().execute();
    }
}
