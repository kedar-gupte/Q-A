package TreesAndGraphs;

import Base.BaseExecutor;

import java.util.*;

public class MakeNetworkConnected implements BaseExecutor {

    public int makeConnected(int n, int[][] connections) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] c : connections) {
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(c[0]);
        }

        //System.out.println(graph);

        int subGraphs = 0, redundant = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++) {

            if(!visited.contains(i)) {

                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited.add(i);
                // Already connected metric is used to see nodes connected within subgraph but not yet taken up in queue
                Set<Integer> alreadyConnected = new HashSet<>();

                while(!queue.isEmpty()) {

                    Integer temp = queue.poll();
                    alreadyConnected.add(temp);
                    //System.out.println("+" + temp);
                    for(Integer child : graph.get(temp)) {
                        if(!visited.contains(child)) {
                            visited.add(child);
                            queue.add(child);
                        } else if(!alreadyConnected.contains(child)) {
                            redundant++;
                        }
                    }

                }

                subGraphs++;
            }

        }

        System.out.println(subGraphs + " " + redundant);

        if(subGraphs == 1) {
            return 0;
        } else {
            if(redundant - (subGraphs - 1) >= 0) {
                return subGraphs - 1;
            } else {
                return -1;
            }
        }

    }

    @Override
    public void execute() {

        int[][] nums1 = {{0,1},{0,2},{0,3},{1,2}};
        System.out.println(makeConnected(6, nums1));
        
        int[][] nums2 = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        System.out.println(makeConnected(6, nums2));

    }

    public static void main(String[] args) {
        new MakeNetworkConnected().execute();
    }
}
