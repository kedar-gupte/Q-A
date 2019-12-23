package Design;

import Base.BaseExecutor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LRU Cache
 * https://leetcode.com/explore/interview/card/google/65/design-4/3090/
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 */

public class LRUCache implements BaseExecutor {

    Integer limit;
    Map<Integer, String> map;
    LinkedList<Integer> priority;

    void init(Integer size) {
        this.limit = size;
        map = new HashMap<>();
        priority = new LinkedList<>();
    }

    void put(Integer key, String value) {

        if(map.size() == limit) {
            // Remove the least recently used
            Integer removedKey = priority.removeLast();
            map.remove(removedKey);
        }

        // Add the element and move key to top
        map.put(key, value);
        priority.remove(key);
        priority.addFirst(key);

    }

    String get(Integer key) {

        if(map.containsKey(key)) {
            priority.remove(key);
            priority.addFirst(key);
            return map.get(key);
        } else {
            return null;
        }


    }

    @Override
    public void execute() {

        init(3);
        put(1, "a"); // a
        put(2, "b"); // b a
        System.out.println(get(2)); // [b] b a
        put(3, "c"); // c b a
        System.out.println(get(1)); // [a] a c b
        put(4, "d"); // d a c
        System.out.println(get(2)); // null

    }

    public static void main(String[] args) {

        new LRUCache().execute();

    }

}
