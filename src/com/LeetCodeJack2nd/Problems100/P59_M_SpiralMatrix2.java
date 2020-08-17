package com.LeetCodeJack2nd.Problems100;

public class P59_M_SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int left = 0;
        int bot = n - 1;
        int right = n - 1;
        int num = 1;
        while (left < right && top < bot) {
            for (int i = left; i <= right - 1; i++) {
                matrix[top][i] = num;
                num++;
            }
            for (int j = top; j <= bot - 1; j++) {
                matrix[j][right] = num;
                num++;
            }
            for (int x = right; x >= left + 1; x--) {
                matrix[bot][x] = num;
                num++;
            }
            for (int y = bot; y >= top + 1; y--) {
                matrix[y][left] = num;
                num++;
            }
            left++;
            top++;
            right--;
            bot--;
        }

        if (top == bot && left == right)
            matrix[top][left] = num;
        return matrix;
    }
}
