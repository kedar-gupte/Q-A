package Base.ArraysString;

import Base.BaseExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window Substring
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/345/
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 */
public class MinimumWindow implements BaseExecutor {

    public String minWindow(String s, String t) {

        Map<Character, Integer> map = stringToCharMap(t);
        Integer size = map.size();

        Integer start = 0, minIndex = 0, maxIndex = 0, maxLength = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);

            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    size--;
                }
            }

            // Substring found in s where all characters of t are present
            if(size == 0) {

                // Iterate forward from start until all characters of t are part of the substring
                while(size == 0) {

                    // Check for minimum length constrain while iterating forward from start position
                    if(i - start + 1 < maxLength) {
                        minIndex = start;
                        maxIndex = i;
                        maxLength = i - start + 1;
                    }

                    Character temp = s.charAt(start);
                    if(map.containsKey(temp)) {
                        // Terminating condition of loop when sub-string no longer has all characters
                        if(map.get(temp) == 0) {
                            size++;
                        }
                        map.put(temp, map.get(temp) + 1);
                    }

                    start++;

                }

            }

        }

        return s.substring(minIndex, maxIndex + 1);
    }

    Map<Character, Integer> stringToCharMap(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;

    }

    @Override
    public void execute() {

        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

    }

    public static void main(String[] args) {

        new MinimumWindow().execute();

    }
}
