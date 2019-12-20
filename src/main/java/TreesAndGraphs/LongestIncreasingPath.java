package TreesAndGraphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem statement
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 */

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class LongestIncreasingPath {

    int X, Y;

    int longestIncreasinPath(int[][] arr) {

        if(arr == null || arr.length == 0) {
            return 0;
        }

        X = arr.length;
        Y = arr[0].length;

        int[][] counts = new int[X][Y];

        for (int i = 0; i < X; i++) {
            Arrays.fill(counts[i], -1);
        }

        int max = 1;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                    max = Math.max(max, dfs(arr, counts, i, j));
            }
        }

        return max;
    }

    int dfs(int[][] arr, int[][] counts, int i, int j) {

        // DP
        if(counts[i][j] != -1) {
            return counts[i][j];
        }

        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        int maximum = 0;
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x >= 0 && x < X && y >= 0 && y < Y) {
                if(arr[i][j] < arr[x][y]) {
                    maximum = Math.max(maximum, dfs(arr, counts, x, y));
                }
            }

        }

        counts[i][j] = 1 + maximum;
        return counts[i][j];
    }


    public static void main(String[] args) {

        int[][] arr = {
                            {3,4,5},
                            {3,2,6},
                            {2,2,1}
                          };

        LongestIncreasingPath obj = new LongestIncreasingPath();
        System.out.println(obj.longestIncreasinPath(arr));

    }

}
