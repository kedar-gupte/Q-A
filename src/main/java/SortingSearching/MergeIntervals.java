package SortingSearching;

import Base.BaseExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge Intervals
 * https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/450/
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 */
public class MergeIntervals implements BaseExecutor {

    class Interval {

        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> result = new ArrayList<>();

        if(intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(int i = 1; i < intervals.size(); i++) {

            Interval temp = intervals.get(i);
            if(temp.start < end) {
                end = Math.max(end, temp.end);
            } else {
                Interval newInterval = new Interval(start, end);
                result.add(newInterval);
                start = temp.start;
                end = temp.end;
            }
        }

        Interval newInterval = new Interval(start, end);
        result.add(newInterval);

        return result;
    }

    @Override
    public void execute() {

        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(15,18);
        List<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);

        merge(list).forEach(i -> {
            System.out.println(i.start + " " + i.end);
        });
    }

    public static void main(String[] args) {

        new MergeIntervals().execute();

    }
}
