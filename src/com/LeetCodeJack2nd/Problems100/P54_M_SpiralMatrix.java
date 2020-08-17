package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P54_M_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return resList;

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int top = 0;
        int bot = m - 1;
        int left = 0;
        int right = n - 1;

        while (left <= right && top <= bot) {
            for (int i = left; i <= right; i++)
                if (!visited[top][i]) {
                    visited[top][i] = true;
                    resList.add(matrix[top][i]);
                }
            for (int j = top + 1; j < bot; j++)
                if (!visited[j][right]) {
                    visited[j][right] = true;
                    resList.add(matrix[j][right]);
                }
            for (int x = right; x >= left; x--)
                if (!visited[bot][x]) {
                    resList.add(matrix[bot][x]);
                    visited[bot][x] = true;
                }

            for (int y = bot - 1; y > top; y--)
                if (!visited[y][left]) {
                    resList.add(matrix[y][left]);
                    visited[y][left] = true;
                }

            left++;
            top++;
            right--;
            bot--;
        }
        return resList;
    }
}
