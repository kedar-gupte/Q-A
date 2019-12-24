package Recursion;


import Base.BaseExecutor;

import java.util.*;

/**
 * Word Squares
 * https://leetcode.com/explore/interview/card/google/62/recursion-4/370/
 *
 * Given a set of words (without duplicates), find all word squares you can build from them.
 *
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 *
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
 *
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 */

public class WordSquares implements BaseExecutor {

    class Dictionary {

        public List<String> words = new ArrayList<>();
        public Map<Character, Dictionary> map = new HashMap<>();

    }

    public List<List<String>> wordSquares(String[] words) {

        List<List<String>> result = new ArrayList<>();

        if(words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();

        Dictionary dictionary = new Dictionary();

        for(String s : words) {

            Dictionary node = dictionary;
            for(Character c : s.toCharArray()) {

                if(node.map.containsKey(c)) {
                    node = node.map.get(c);
                    node.words.add(s);
                } else {
                    Dictionary temp = new Dictionary();
                    temp.words.add(s);
                    node.map.put(c, temp);
                    node = temp;
                }

            }

        }

        for(String s : words) {
            List<String> list = new ArrayList<>();
            list.add(s);
            constructSquare(result, list, dictionary, 1, wordLength);
        }

        return result;
    }

    void constructSquare(List<List<String>> result, List<String> list, Dictionary dictionary, int index, int wordLength) {

        if(index == wordLength) {
            result.add(new ArrayList<>(list));
            return;
        } else {

            Dictionary node = dictionary;
            for(String word : list) {
                Character c = word.charAt(index);
                node = node.map.get(c);
                if(node == null)
                    return;
            }


            for(String word : node.words) {
                list.add(word);
                constructSquare(result, list, dictionary, index + 1, wordLength);
                list.remove(list.size() - 1);
            }

        }

    }

    @Override
    public void execute() {

        String[] words1 = {"area","lead","wall","lady","ball"};

        wordSquares(words1).forEach( list -> {
            list.forEach(x -> {
                System.out.println(x);
            });
            System.out.println();
        });

        String[] words2 = {"momy","oooo","yoyo"};

        wordSquares(words2).forEach( list -> {
            list.forEach(x -> {
                System.out.println(x);
            });
            System.out.println();
        });

    }

    public static void main(String[] args) {

        new WordSquares().execute();

    }
}
