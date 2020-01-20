package SortingSearching;

import Base.BaseExecutor;

import java.util.*;

/**
 * https://leetcode.com/explore/interview/card/uber/289/array-and-string/1684/
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class GroupAnagrams implements BaseExecutor {

    List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int i = 0;
        for(String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = String.valueOf(charArray);
            if(map.containsKey(sorted)) {
                result.get(map.get(sorted)).add(s);
            } else {
                map.put(sorted, i++);
                List<String> list = new ArrayList<>();
                list.add(s);
                result.add(list);
            }
        }

        return result;
    }

    @Override
    public void execute() {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(arr).forEach(e -> {
            System.out.println(Arrays.toString(e.toArray()));
        });
    }

    public static void main(String[] args) {
        new GroupAnagrams().execute();
    }
}
