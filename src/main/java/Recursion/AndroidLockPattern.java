package Recursion;

import Base.BaseExecutor;

import java.util.HashSet;
import java.util.Set;

/**
 * Android Unlock Patterns
 * https://leetcode.com/explore/interview/card/google/62/recursion-4/484/
 *
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
 *
 *
 *
 * Rules for a valid pattern:
 *
 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
 * The order of keys used matters.
 *
 * In this case the third rule is relaxed and only immediate surrounding 8 elements can be used.
 * 
 */

public class AndroidLockPattern implements BaseExecutor {

    class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return (x*10) + y;
        }

        @Override
        public boolean equals(Object obj) {
            return ((Point)obj).x == x && ((Point)obj).y == y;
        }

    }

    int X = 3, Y = 3;
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
    int result = 0;

    public int numberOfPatterns(int m, int n) {

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                Set<Point> visited = new HashSet<>();
                visited.add(new Point(i, j));
                dfs(i, j, visited, m - 1, n - 1);
            }
        }

        return result;
    }

    void dfs(int i, int j, Set<Point> visited, int m, int n) {

        if(m <= 0) {
            result++;
        }

        if(n == 0) {
            return;
        }

        for(int[] dir : dirs) {

            int x = i + dir[0], y = j + dir[1];

            if(x >= 0 && x < X && y >= 0 && y < Y) {

                Point p = new Point(x,y);
                System.out.println(visited.contains(p));
                if(visited.contains(p)) {
                    dfs(x, y, visited, m, n);
                } else {
                    visited.add(p);
                    dfs(x, y, visited, m - 1, n - 1);
                    visited.remove(p);
                }

            }

        }

    }

    @Override
    public void execute() {

        System.out.println(numberOfPatterns(1,3));

    }

    public static void main(String[] args) {

        new AndroidLockPattern().execute();

    }
}
