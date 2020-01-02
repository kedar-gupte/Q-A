package Base.ArraysString;

import Base.BaseExecutor;

import java.util.HashMap;
import java.util.Map;

public class SubstringDistinctCharacters implements BaseExecutor {

    public int lengthOfLongestSubstringDistinct(String s, int n) {

        Map<Character, Integer> map = new HashMap<>();

        int start = 0, result = 0;

        for (int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.size() == n) {
                result = Math.max(result, i - start + 1);
            } else {
                while(map.size() > n) {
                    Character temp = s.charAt(start);
                    map.put(temp, map.get(temp) - 1);
                    if(map.get(temp) == 0) {
                        map.remove(temp);
                    }
                    start++;
                }
            }

        }

        return result;
    }

    @Override
    public void execute() {

        System.out.println(lengthOfLongestSubstringDistinct("ccaabbb", 2));

    }

    public static void main(String[] args) {
        new SubstringDistinctCharacters().execute();
    }
}
