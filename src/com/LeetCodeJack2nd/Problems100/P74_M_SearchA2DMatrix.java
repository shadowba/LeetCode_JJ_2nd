package com.LeetCodeJack2nd.Problems100;

public class P74_M_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bot = m - 1, left = 0, right = n - 1, mid = 0;
        while (top+1 < bot) {
            mid = (top + bot) / 2;
            if (target >= matrix[mid][0]) {
                if (matrix[mid][0] == target) return true;
                top = mid;
            }
            else
                bot = mid - 1;
        }
        int row = top;
        if(bot>top && target>=matrix[bot][0])
            row = bot;

        while (left <= right) {
            mid = (left + right) / 2;
            if (matrix[row][mid] == target)
                return true;
            else if (target > matrix[row][mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
