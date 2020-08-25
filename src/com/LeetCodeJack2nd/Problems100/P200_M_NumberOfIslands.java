package com.LeetCodeJack2nd.Problems100;

public class P200_M_NumberOfIslands {
    int m,n;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    grid[i][j] = '2';
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '2')
                    cnt++;
            }
        }
        return cnt;
    }

    private void helper(char[][] grid, int i, int j) {
        if (grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') helper(grid, i - 1, j);
        if (i + 1 <= m - 1 && grid[i + 1][j] == '1') helper(grid, i + 1, j);
        if (j - 1 >= 0 && grid[i][j - 1] == '1') helper(grid, i, j - 1);
        if (j + 1 <= n - 1 && grid[i][j + 1] == '1') helper(grid, i, j + 1);
    }
}
