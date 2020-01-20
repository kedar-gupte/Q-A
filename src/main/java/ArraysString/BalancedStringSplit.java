package ArraysString;

import Base.BaseExecutor;

/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string s split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of splitted balanced strings.
 *
 */
public class BalancedStringSplit implements BaseExecutor {

    int balancedStringSplit(String s) {

        int count = 0, result = 0;
        for(Character c : s.toCharArray()) {
            if(c == 'R') {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                result++;
            }
        }
        return result;
    }

    @Override
    public void execute() {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }

    public static void main(String[] args) {
        new BalancedStringSplit().execute();
    }
}
