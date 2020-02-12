package TreesAndGraphs;

import Base.BaseExecutor;
import java.util.*;

/**
 * Duplicate subtrees
 * https://leetcode.com/explore/interview/card/uber/296/trees-and-graphs/1729/
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with same node values.
 */
public class DuplicateSubtrees implements BaseExecutor {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();

        serialiseTree(root, map, result);

        return result;
    }

    String serialiseTree(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {

        if(node == null) {
            return "#";
        }

        String temp = node.val + serialiseTree(node.left, map, result) + serialiseTree(node.right, map, result);
        map.put(temp, map.getOrDefault(temp, 0) + 1);
        if(map.get(temp) == 2) {
            result.add(node);
        }

        return temp;
    }

    @Override
    public void execute() {

    }

    public static void main(String[] args) {
        new DuplicateSubtrees().execute();
    }
}
