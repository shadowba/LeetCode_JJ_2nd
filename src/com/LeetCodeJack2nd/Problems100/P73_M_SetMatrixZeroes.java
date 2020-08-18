package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P73_M_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> rowSet = new HashSet<>();
        int i = 0, j = 0;
        int r = matrix.length, c = matrix[0].length;
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                if ((rowSet.contains(i) || colSet.contains(j))) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
