package TreesAndGraphs;

import Base.BaseExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Print binary tree
 * https://leetcode.com/explore/interview/card/uber/296/trees-and-graphs/1730/
 *
 * Example 1:
 * Input:
 *      1
 *     /
 *    2
 * Output:
 * [["", "1", ""],
 * ["2", "", ""]]
 */
public class PrintBinaryTree implements BaseExecutor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<String>> printTree(TreeNode root) {

        List<List<String>> result = new ArrayList<>();
        int height = heightOfTree(root);
        Integer size = ((Double)Math.pow(2, height)).intValue() - 1;
        for(int i = 0; i < height; i++) {
            String[] arr = new String[size];
            Arrays.fill(arr, "");
            result.add(Arrays.asList(arr));
        }
        System.out.println(result);
        fillLists(root, 0, 0, size, result);

        return result;
    }

    void fillLists(TreeNode node, int level, int start, int end, List<List<String>> result) {

        if(node == null) {
            return;
        }

        int mid = (start + end)/2;

        List<String> list = result.get(level);
        list.set(mid, Integer.toString(node.val));

        fillLists(node.left, level + 1, start, mid - 1, result);
        fillLists(node.right, level + 1, mid + 1, end, result);
    }

    int heightOfTree(TreeNode node) {
        if(node == null)
            return 0;
        return Math.max(1 + heightOfTree(node.left), 1 + heightOfTree(node.right));
    }

    @Override
    public void execute() {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        System.out.println(printTree(node));
    }

    public static void main(String[] args) {
        new PrintBinaryTree().execute();
    }
}
