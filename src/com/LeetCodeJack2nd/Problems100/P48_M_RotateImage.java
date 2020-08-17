package com.LeetCodeJack2nd.Problems100;

public class P48_M_RotateImage {
    public void rotate(int[][] matrix) {
        int top = 0;
        int bot = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int n = matrix.length;
        while (left < right && top < bot) {
            for (int i = top; i < bot; i++) {
                swap(matrix, top, i, i, right);
            }
            for (int i = right; i > left; i--) {
                swap(matrix, top, n - 1 - i, bot, i);
            }
            for (int i = bot; i > top; i--) {
                swap(matrix, top, n - 1 - i, i, left);
            }
            top++;
            left++;
            bot--;
            right--;
        }
    }

    private void swap(int[][] matrix, int i, int j, int m, int n) {
        int temp = matrix[m][n];
        matrix[m][n] = matrix[i][j];
        matrix[i][j] = temp;
    }
}
