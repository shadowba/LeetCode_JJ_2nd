package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P120_M_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int maxRow = triangle.size();
        int j = 0;
        if (maxRow == 1)
            return triangle.get(0).get(0);
        int[] lastRow = new int[maxRow];
        int[] temp = new int[maxRow];
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        lastRow[0] = triangle.get(0).get(0);
        for (int row = 1; row < maxRow; row++) {
            j = triangle.get(row).size();
            min = Integer.MAX_VALUE;
            for (int col = 0; col < j; col++) {
                left = (col - 1 >= 0) ? lastRow[col - 1] : lastRow[0];
                right = (col > row - 1) ? lastRow[col - 1] : lastRow[col];
                sum = triangle.get(row).get(col) + Math.min(left, right);
                temp[col] = sum;
                min = Math.min(sum, min);
            }
            for (int i = 0; i < row+1; i++)
                lastRow[i] = temp[i];
        }
        return min;
    }
}
