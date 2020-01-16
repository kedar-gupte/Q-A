package HeapsAndQueues;

import Base.BaseExecutor;

import java.lang.reflect.Array;
import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Exclusive time of functions
 * https://leetcode.com/explore/interview/card/uber/292/heap-queue-stack/1703/
 *
 * Input:
 * n = 2
 * logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * Output: [3, 4]
 * Explanation:
 * Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
 * Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
 * Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time.
 * So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
 *
 */
public class ExclusiveTimeOfFunctions implements BaseExecutor {

    public Integer[] exclusiveTime(int n, List<String> logs) {

        Integer[] result = new Integer[n];
        Arrays.fill(result, 0);

        Stack<Integer> stack = new Stack<>();
        Integer prev = 0;

        for(String log : logs) {

            String[] s = log.split(":");
            Integer index = Integer.valueOf(s[0]);
            Integer currentTime = Integer.valueOf(s[2]);

            // If stack is empty then the first log is of start
            if(stack.isEmpty()) {

                stack.push(index);
                prev = currentTime;

            } else {

                if(s[1].equals("start")) {

                    Integer currIndex = stack.peek();
                    result[currIndex] = result[currIndex] + (currentTime - prev);
                    stack.push(index);
                    prev = currentTime;

                } else if(s[1].equals("end")) {

                    result[stack.peek()] = result[stack.peek()] + (currentTime - prev + 1);
                    stack.pop();
                    prev = currentTime + 1;

                }
            }

        }

        return result;
    }

    @Override
    public void execute() {

        String[] arr = {"0:start:0","1:start:2","1:end:5","0:end:6"};
        System.out.println(Arrays.toString(exclusiveTime(2, Arrays.asList(arr))));

    }

    public static void main(String[] args) {
        new ExclusiveTimeOfFunctions().execute();
    }
}
