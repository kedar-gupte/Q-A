package SortingSearching;

import Base.BaseExecutor;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Median of two sorted Arrays
 * https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/3080/
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 */
public class MedianOfTwoSortedArrays implements BaseExecutor {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> e2 - e1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((e1, e2) -> e1 - e2);

        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            Integer value = null;
            if(nums1[i] < nums2[j]) {
                value = nums1[i];
                i++;
            } else {
                value = nums2[j];
                j++;
            }

            insert(maxHeap, minHeap, value);
        }

        while(i < nums1.length) {
            insert(maxHeap, minHeap, nums1[i]);
            i++;
        }

        while(j < nums2.length) {
            insert(maxHeap, minHeap, nums2[j]);
            j++;
        }

        maxHeap.forEach(e -> System.out.println(e));
        System.out.println();
        minHeap.forEach(e -> System.out.println(e));

        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.poll() + minHeap.poll())/2.0;
        } else {
            return maxHeap.poll();
        }
    }


    void insert(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, Integer value) {
        // Count in left is one greater than count in right

        Integer topLeft = maxHeap.peek(), topRight = minHeap.peek();
        // Left maxHeap will be filled up first. Re-balancing will happen in next step to insert elements in minHeap
        if(topLeft == null || value <= topLeft) {
            maxHeap.add(value);
        } else {
            minHeap.add(value);
        }

        // Re-balancing to have left maxHeap to be 1 greater than minHeap
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    @Override
    public void execute() {

        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static void main(String[] args) {
        new MedianOfTwoSortedArrays().execute();
    }
}
