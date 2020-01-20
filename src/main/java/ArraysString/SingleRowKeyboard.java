package ArraysString;

import Base.BaseExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/single-row-keyboard/
 * There is a special keyboard with all keys in a single row.
 *
 * Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25), initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.
 *
 * You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.
 *
 *
 *
 * Example 1:
 *
 * Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
 * Output: 4
 * Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' then to 0 again to write 'a'.
 * Total time = 2 + 1 + 1 = 4.
 *
 */
public class SingleRowKeyboard implements BaseExecutor {

    public int calculateTime(String keyboard, String word) {

        if(word == null || word.isEmpty())
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(Character c : keyboard.toCharArray()) {
            map.put(c, i);
            i++;
        }

        int result = map.get(word.charAt(0));
        for(i = 1; i < word.length(); i++) {
            result += Math.abs(map.get(word.charAt(i)) - map.get(word.charAt(i - 1)));
        }
        return result;
    }

    @Override
    public void execute() {
        System.out.println(calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"));
    }

    public static void main(String[] args) {
        new SingleRowKeyboard().execute();
    }
}
