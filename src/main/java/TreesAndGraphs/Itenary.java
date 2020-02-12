package TreesAndGraphs;

import Base.BaseExecutor;

import java.util.*;

/**
 * Reconstruct Itenary
 * https://leetcode.com/explore/interview/card/uber/296/trees-and-graphs/1727/
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 */
public class Itenary implements BaseExecutor {

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(List<String> list : tickets) {
            map.putIfAbsent(list.get(0), new PriorityQueue<>());
            map.get(list.get(0)).add(list.get(1));
        }

        System.out.println(map);

        dfs("JFK", map, result);
        return result;
    }

    void dfs(String node, Map<String, PriorityQueue<String>> map, List<String> result) {

        PriorityQueue<String> queue = map.get(node);

        while(queue != null && !queue.isEmpty()) {
            dfs(queue.poll(), map, result);
        }

        result.add(0, node);

    }

    @Override
    public void execute() {
        List<List<String>> tickets = new ArrayList<>();
        String[] s1 = {"JFK","SFO"}; tickets.add(Arrays.asList(s1));
        String[] s2 = {"JFK","ATL"}; tickets.add(Arrays.asList(s2));
        String[] s3 = {"SFO","ATL"}; tickets.add(Arrays.asList(s3));
        String[] s4 = {"ATL","JFK"}; tickets.add(Arrays.asList(s4));
        String[] s5 = {"ATL","SFO"}; tickets.add(Arrays.asList(s5));
        System.out.println(findItinerary(tickets));
    }

    public static void main(String[] args) {
        new Itenary().execute();
    }
}
