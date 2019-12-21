package TreesAndGraphs;


import Base.BaseExecutor;

import java.util.*;

/**
 *
 * Evaluate Division
 * https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/331/
 *
 * Equations are given in the format A / Base.BaseExecutor = k, where A and Base.BaseExecutor are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 */

public class DecodeDivision implements BaseExecutor {

    class Node {

        String value;
        double weight;

        Node(String value, double weight) {
            this.value = value;
            this.weight = weight;
        }

    }

    Map<String, List<Node>> graph;
    Set<String> nodes;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // Create a directed graph
        graph = new HashMap<>();
        nodes = new HashSet<>();
        int index = 0;
        for(List<String> list : equations) {
            String s1 = list.get(0);
            String s2 = list.get(1);
            nodes.add(s1);
            nodes.add(s2);

            graph.putIfAbsent(s1, new ArrayList<>());
            graph.get(s1).add(new Node(s2, values[index]));
            graph.putIfAbsent(s2, new ArrayList<>());
            graph.get(s2).add(new Node(s1, 1/values[index]));

            index++;
        }

        double[] result = new double[queries.size()];

        // For each query traverse the graph and multiply the values along the path
        index = 0;
        for(List<String> query : queries) {
            String source = query.get(0);
            String destination = query.get(1);

            if(nodes.contains(source) && nodes.contains(destination)) {
                if(source.equals(destination)) {
                    result[index] = 1;
                } else {

                    Set<String> visited = new HashSet<>();
                    visited.add(source);
                    result[index] = dfs(source, destination, visited, 1.0);

                }
            } else {
                result[index] = -1;
            }


            index++;
        }

        return result;

    }

    double dfs(String currentNode, String destination, Set<String> visited, double weight) {

        if(currentNode.equals(destination)) {
            return weight;
        }

        for(Node node : graph.get(currentNode)) {

            if(!visited.contains(node.value)) {
                double w = weight * node.weight;
                visited.add(node.value);
                double val = dfs(node.value, destination, visited, w);
                if(val != -1)
                    return val;
                visited.remove(node.value);
            }

        }

        return -1;
    }

    @Override
    public void execute() {

        List<List<String>> equations = new ArrayList<>();
        List<String> e1 = new ArrayList<>();
        e1.add("a"); e1.add("b");
        equations.add(e1);
        List<String> e2 = new ArrayList<>();
        e2.add("b"); e2.add("c");
        equations.add(e2);

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        q1.add("a"); q1.add("c");
        queries.add(q1);
        List<String> q2 = new ArrayList<>();
        q2.add("b"); q2.add("a");
        queries.add(q2);
        List<String> q3 = new ArrayList<>();
        q3.add("a"); q3.add("e");
        queries.add(q3);
        List<String> q4 = new ArrayList<>();
        q4.add("a"); q4.add("a");
        queries.add(q4);
        List<String> q5 = new ArrayList<>();
        q5.add("a"); q5.add("a");
        queries.add(q5);

        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));

    }

    public static void main(String[] args) {

        new DecodeDivision().execute();

    }
}
