package com.LeetCodeJack2nd.Problems100;

public class P79_M_WordSearch {
    boolean[][] visited;
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (helper(board, i, j, 1, word))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int curRow, int curCol, int curSize, String word) {
        if (curSize == word.length())
            return true;

        char ch = word.charAt(curSize);
        if (curRow - 1 >= 0 && board[curRow - 1][curCol] == ch && visited[curRow - 1][curCol] == false) {
            visited[curRow - 1][curCol] = true;
            if (helper(board, curRow - 1, curCol, curSize + 1, word))
                return true;
            visited[curRow - 1][curCol] = false;
        }
        if (curCol - 1 >= 0 && board[curRow][curCol - 1] == ch && visited[curRow][curCol - 1] == false) {
            visited[curRow][curCol - 1] = true;
            if (helper(board, curRow, curCol - 1, curSize + 1, word))
                return true;
            visited[curRow][curCol - 1] = false;
        }
        if (curRow + 1 < m && board[curRow + 1][curCol] == ch && visited[curRow + 1][curCol] == false) {
            visited[curRow + 1][curCol] = true;
            if (helper(board, curRow + 1, curCol, curSize + 1, word))
                return true;
            visited[curRow + 1][curCol] = false;
        }
        if (curCol + 1 < n && board[curRow][curCol + 1] == ch && visited[curRow][curCol + 1] == false) {
            visited[curRow][curCol + 1] = true;
            if (helper(board, curRow, curCol + 1, curSize + 1, word))
                return true;
            visited[curRow][curCol + 1] = false;
        }
        return false;
    }
}
