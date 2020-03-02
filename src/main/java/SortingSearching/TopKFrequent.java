package SortingSearching;

import Base.BaseExecutor;

import java.util.*;

class TopKFrequent implements BaseExecutor {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (e1,e2) -> {
                    if(e1.getValue() != e2.getValue())
                        return e1.getValue() - e2.getValue();
                    else
                        return e2.getKey().compareTo(e1.getKey());
                }
        );

        for(String word : words) {

            map.put(word, map.getOrDefault(word, 0) + 1);
            int count = map.get(word);

        }

        for(Map.Entry<String, Integer> e : map.entrySet()) {

            if(queue.size() < k) {
                queue.add(e);
            } else {
                if(queue.peek().getValue() < e.getValue() ||
                        ((queue.peek().getValue() == e.getValue()) && (queue.peek().getKey().compareTo(e.getKey()) > 0))) {
                    queue.poll();
                    queue.add(e);
                }
            }

        }

        List<String> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            list.add(0, queue.poll().getKey());
        }

        return list;

    }

    @Override
    public void execute() {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent(words, 4));
    }

    public static void main(String[] args) {
        new TopKFrequent().execute();
    }
}
