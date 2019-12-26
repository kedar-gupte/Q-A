package TreesAndGraphs;

import Base.BaseExecutor;

import java.util.*;

/**
 * Word Ladder
 * https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3068/
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 */

public class WordLadder implements BaseExecutor {

    class Pair {

        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }

    }

    public int ladderLength(String beginWord, String endWord, String[] wordList) {

        // Create a graph of words with one character difference
        Map<String, List<String>> graph = new HashMap<>();
        int wordLength = wordList[0].length();

        for(String word : wordList) {

            // Get all words with one character substituted
            for(int i = 0; i < wordLength; i++) {

                String temp = word.substring(0, i) + "*" + word.substring(i+1, wordLength);
                List<String> words = graph.getOrDefault(temp, new ArrayList<>());
                words.add(word);
                graph.put(temp, words);

            }

        }

        System.out.println(graph);

        // Perform BFS from begin word to end word
        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(beginWord, 1));

        while(!queue.isEmpty()) {

            Pair p = queue.poll();
            String word = p.word;
            int level = p.level;

            visited.add(word);
            System.out.println(word);

            for (int i = 0; i < wordLength; i++) {

                String temp = word.substring(0, i) + "*" + word.substring(i+1, wordLength);

                if(graph.containsKey(temp)) {

                    for(String w : graph.get(temp)) {

                        if (w.equals(endWord)) {
                            return level + 1;
                        }
                        if (!visited.contains(w)) {
                            queue.add(new Pair(w, level + 1));
                        }

                    }
                    
                }


            }

        }

        return 0;
    }


    @Override
    public void execute() {

        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};

        System.out.println(ladderLength(beginWord, endWord, wordList));

    }

    public static void main(String[] args) {

        new WordLadder().execute();

    }
}
