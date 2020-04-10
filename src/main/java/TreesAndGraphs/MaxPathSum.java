package TreesAndGraphs;

import Base.BaseExecutor;

/**
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 */
public class MaxPathSum implements BaseExecutor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        int sum = buildPathSum(root);
        max = Math.max(max, sum);
        return max;
    }

    public int buildPathSum(TreeNode node) {

        if(node == null) {
            return 0;
        }

        int left = buildPathSum(node.left);
        if(left < 0) {
            left = 0;
        }
        int right = buildPathSum(node.right);
        if(right < 0) {
            right = 0;
        }

        int sum = node.val + left + right;
        max = Math.max(max, sum);

        return Math.max(node.val + left, node.val + right);

    }

    @Override
    public void execute() {

    }

    public static void main(String[] args) {

    }
}
