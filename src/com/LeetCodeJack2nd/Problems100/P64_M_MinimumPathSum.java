package com.LeetCodeJack2nd.Problems100;

public class P64_M_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] map = new int[m][n];
        int i = 0;
        map[0][0] = grid[0][0];
        for (i = 1; i < n; i++)
            map[0][i] = map[0][i - 1] + grid[0][i];
        for (i = 1; i < m; i++)
            map[i][0] = map[i - 1][0] + grid[i][0];
        for (i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = grid[i][j] + Math.min(map[i][j - 1], map[i - 1][j]);
            }
        }
        return map[m - 1][n - 1];
    }
}
