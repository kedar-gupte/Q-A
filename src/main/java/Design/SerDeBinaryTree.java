package Design;

import Base.BaseExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Serialize and Deserialize Binary Tree
 * https://leetcode.com/explore/interview/card/google/65/design-4/3092/
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 */

public class SerDeBinaryTree implements BaseExecutor {

    class Node {

        public String data;
        public Node left;
        public Node right;

        Node(String data) {
            this.data = data;
        }

    }

    int index = 0;

    List<String> serialize(Node root) {

        List<String> list = new ArrayList<>();
        preOrder(root, list);
        return list;

    }

    void preOrder(Node node, List<String> list) {
        if(node == null) {
            list.add("null");
            return;
        }

        list.add(node.data);
        preOrder(node.left, list);
        preOrder(node.right, list);

    }

    Node deserialize(List<String> tree) {


        Node root = constructTree(tree);
        return root;

    }

    Node constructTree(List<String> tree) {

        String value = tree.get(index);

        if(value.equals("null")) {
            return null;
        }

        Node n = new Node(value);
        index++;
        n.left = constructTree(tree);
        index++;
        n.right = constructTree(tree);

        return n;
    }


    @Override
    public void execute() {

        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        List<String> list = serialize(n1);
        System.out.println(list);
        Node n = deserialize(list);
        System.out.println(n.data);
        System.out.println(n.left.data);
        System.out.println(n.right.data);
        System.out.println(n.left.left.data);

    }

    public static void main(String[] args) {

        new SerDeBinaryTree().execute();

    }
}
