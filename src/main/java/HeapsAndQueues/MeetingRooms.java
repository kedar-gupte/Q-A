package HeapsAndQueues;

import Base.BaseExecutor;

import java.util.PriorityQueue;

/**
 * Minimum number of meeting rooms
 * https://leetcode.com/explore/interview/card/uber/292/heap-queue-stack/1701/
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 */
public class MeetingRooms implements BaseExecutor {

    class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    int minMeetingRooms(int[][] intervals) {

        int result = 0;
        PriorityQueue<Interval> in = new PriorityQueue<>((e1, e2) -> e1.start - e2.start);
        PriorityQueue<Interval> queue = new PriorityQueue<>((e1, e2) -> e2.end - e1.end);

        for(int[] interval : intervals) {
            in.add(new Interval(interval[0], interval[1]));
        }

        for(Interval e : in) {

            while(!queue.isEmpty()) {
                Interval temp = queue.peek();
                if(temp.end > e.start) {
                    queue.poll();
                } else {
                    break;
                }
            }
            queue.add(e);

            result = Math.max(result, queue.size());
        }

        return result;
    }

        @Override
    public void execute() {
        int[][] intervals = {{0, 30},{5, 10},{15, 20}};
        System.out.println(minMeetingRooms(intervals));

    }

    public static void main(String[] args) {
        new MeetingRooms().execute();
    }
}
