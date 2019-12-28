package SortingSearching;

import Base.BaseExecutor;

import java.util.Arrays;
import java.util.List;

/**
 * Count small numbers
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76580/9ms-short-Java-BST-solution-get-answer-when-building-BST
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 */
public class CountSmallerNumbers implements BaseExecutor {

    class Node {

        public Node left;
        public Node right;
        public Integer value;
        public Integer countLeft;
        public Integer duplicate;

        Node(Integer value) {
            this.value = value;
            this.countLeft = 1; // Count of the node itself
            this.duplicate = 0;
        }

    }

    public List<Integer> countSmaller(int[] nums) {

        Integer[] result = new Integer[nums.length];
        Node root = null;

        for (int i = nums.length - 1; i >= 0 ; i--) {
            root = insertIntoTree(root, nums[i], 0, result, i);
        }

        return Arrays.asList(result);
    }

    Node insertIntoTree(Node currentNode, int value, int count, Integer[] result, int index) {

        if(currentNode == null) {
            currentNode = new Node(value);
            result[index] = count;
        } else if(currentNode.value == value) {
            currentNode.duplicate++;
            result[index] = count + currentNode.countLeft;
        } else if(currentNode.value < value) {
            currentNode.right =
                    insertIntoTree(currentNode.right, value, count + currentNode.countLeft + currentNode.duplicate, result, index);
        } else if(currentNode.value > value) {
            currentNode.countLeft++;
            currentNode.left =
                    insertIntoTree(currentNode.left, value, count, result, index);
        }

        return currentNode;
    }

    @Override
    public void execute() {

        int[] nums = {4, 7, 3, 2, 2, 6, 1};
        System.out.println(countSmaller(nums));

    }

    public static void main(String[] args) {

        new CountSmallerNumbers().execute();

    }
}
