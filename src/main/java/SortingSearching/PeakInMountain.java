package SortingSearching;

import Base.BaseExecutor;

public class PeakInMountain implements BaseExecutor {

    public int maxSubArray(int[] A) {

        int start = 0, end = A.length - 1;

        while(start < end) {
            int mid = (start + end) / 2;
            if(A[mid] > A[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;

    }

    @Override
    public void execute() {

        int[] nums = {0,2,1,0};
        System.out.println(maxSubArray(nums));

    }

    public static void main(String[] args) {

        new PeakInMountain().execute();

    }
}
