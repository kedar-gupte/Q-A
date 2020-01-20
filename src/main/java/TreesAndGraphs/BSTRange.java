package TreesAndGraphs;

import Base.BaseExecutor;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 */
public class BSTRange implements BaseExecutor {

     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    class Solution {
        int result = 0;
        public int rangeSumBST(TreeNode root, int L, int R) {
            if(root == null) {
                return 0;
            }
            if(root.val >= L && root.val <= R) {
                result += root.val;
            }
            rangeSumBST(root.left, L, R);
            rangeSumBST(root.right, L, R);
            return result;
        }
    }

    @Override
    public void execute() {

    }

    public static void main(String[] args) {
        new BSTRange().execute();
    }
}
