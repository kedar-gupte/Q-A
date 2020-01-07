package Recursion;

import Base.BaseExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * https://leetcode.com/explore/interview/card/google/62/recursion-4/3079/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class GenerateParanthesis implements BaseExecutor {

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        generateParenthesis(n, n, "", list);
        return list;

    }

    void generateParenthesis(int open, int close, String s, List<String> list) {

        if(open == 0 && close == 0) {
            list.add(s);
            return;
        }

        if(open > 0) {
            generateParenthesis(open - 1, close, s + "(", list);
        }

        if(open < close) {
            generateParenthesis(open, close - 1, s + ")", list);
        }

    }

    @Override
    public void execute() {

        generateParenthesis(4).forEach(e -> System.out.println(e));

    }

    public static void main(String[] args) {

        new GenerateParanthesis().execute();

    }
}
