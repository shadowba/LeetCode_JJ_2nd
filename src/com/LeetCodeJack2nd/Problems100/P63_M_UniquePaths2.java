package com.LeetCodeJack2nd.Problems100;

public class P63_M_UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1 )
            return 0;
        int[][] map = new int[m][n];

        int i = 0;
        for (i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1)
                map[0][i] = 1;
            else
                break;
        }
        for (i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1)
                map[i][0] = 1;
            else
                break;
        }
        for (i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    map[i][j] = 0;
                    continue;
                } else
                    map[i][j] = map[i - 1][j] + map[i][j-1];
            }
        }
        return map[m - 1][n - 1];
    }
}
