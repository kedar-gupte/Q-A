package HeapsAndQueues;

import Base.BaseExecutor;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.util.*;

/**
 * Task Scheduler
 * https://leetcode.com/explore/interview/card/uber/292/heap-queue-stack/1702/
 *
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 *
 *
 * Example:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 */

public class TaskScheduler implements BaseExecutor {

    public int leastInterval(char[] tasks, int n) {

        int result = 0;
        // Character count map
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Priority queue with entry points in map sorted in descending order
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        queue.addAll(map.entrySet());

        while(!queue.isEmpty()) {

            // Initialize second queue to add numbers from first whose count is greater than zero
            Queue<Map.Entry<Character, Integer>> temp = new LinkedList<>();
            int i = 0;
            while(!(queue.isEmpty() && temp.isEmpty()) && i <= n) {
                if(!queue.isEmpty()) {
                    Map.Entry<Character, Integer> e = queue.poll();
                    e.setValue(e.getValue() - 1);
                    if(e.getValue() > 0) {
                        temp.add(e);
                    }
                }
                result++;
                i++;
            }
            queue.addAll(temp);

        }

        return result;
    }

    @Override
    public void execute() {
        char[] tasks = {'A', 'B', 'B', 'A', 'C', 'B', 'A'};
        System.out.println(leastInterval(tasks, 1));
        System.out.println(leastInterval(tasks, 2));
    }

    public static void main(String[] args) {
        new TaskScheduler().execute();
    }
}
