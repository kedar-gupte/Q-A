package Recursion;

import Base.BaseExecutor;

import java.util.*;

/**
 * Word Search
 * https://leetcode.com/explore/interview/card/google/62/recursion-4/462/
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example:
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 *
 */
public class WordSearch implements BaseExecutor {

    class Node {

        public Map<Character, Node> map = new HashMap<>();
        boolean isWord = false;

    }

    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int X, Y;

    public List<String> findWords(char[][] board, String[] words) {

        Node dictionary = new Node();
        Set<String> result = new HashSet<>();

        X = board.length;
        Y = board[0].length;

        for(String s : words) {

            Node n = dictionary;
            for(Character c : s.toCharArray()) {
                Node next = n.map.get(c);
                if(next == null) {
                    next = new Node();
                    n.map.put(c, next);
                }
                n = next;
            }
            n.isWord = true;

        }

        boolean[][] visited = new boolean[X][Y];
        for (int i = 0; i < X; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                visited[i][j] = true;
                findWords(board, visited, i, j, dictionary.map.get(board[i][j]), "" + board[i][j], result);
                visited[i][j] = false;
            }
        }

        return new ArrayList<>(result);
    }

    void findWords(char[][] board, boolean[][] visited, int x, int y, Node node, String word, Set<String> words) {

        if(node == null) {
            return;
        }

        if(node.isWord == true) {
            words.add(word);
        }

        for(int[] dir : dirs) {

            int _x = x + dir[0];
            int _y = y + dir[1];

            if(_x >= 0 && _x < X && _y >= 0 && _y < Y && !visited[_x][_y]) {
                visited[_x][_y] = true;
                findWords(board, visited, _x, _y, node.map.get(board[_x][_y]), word + board[_x][_y], words);
                visited[_x][_y] = false;
            }

        }

    }

    @Override
    public void execute() {

        char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        findWords(board, words).forEach(e -> System.out.println(e));

    }

    public static void main(String[] args) {

        new WordSearch().execute();

    }
}
