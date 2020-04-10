package ArraysString;

import Base.BaseExecutor;

/**
 *
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 *
 * There is at least one empty seat, and at least one person sitting.
 *
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 *
 * Return that maximum distance to closest person.
 *
 * Example 1:
 *
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 *
 */
public class MaxDistance implements BaseExecutor {

    public int maxDistToClosest(int[] seats) {

        int max = 0, runLength = 0;
        boolean priorOne = false;
        for(int s : seats) {

            if(s == 0) {
                runLength++;
            } else {
                System.out.println((Math.ceil(runLength/2)));
                if(priorOne)
                    max = Math.max(max, (int)(Math.ceil(runLength/2.0)));
                else
                    max = runLength;
                priorOne = true;
                runLength = 0;
                System.out.println(max);
            }

        }
        max = Math.max(max, runLength);

        return max;

    }

    @Override
    public void execute() {

        int[] nums = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(nums));

    }

    public static void main(String[] args) {

        new MaxDistance().execute();

    }
}
