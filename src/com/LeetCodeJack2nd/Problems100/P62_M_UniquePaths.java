package com.LeetCodeJack2nd.Problems100;

public class P62_M_UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    map[i][j] = 1;
                    continue;
                }
                map[i][j] = map[i][j - 1] + map[i - 1][j];
            }
        }
        return map[m - 1][n - 1];
    }
}
