package com.LeetCodeJack2nd.Problems100;

public class P130_M_SurroundedRegions {
    int m;
    int n;
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0)
            return;
        m = board.length;
        n = board[0].length;
        int[][] map = new int[m][n];
        for(int i=0; i<n;i++){
            if(board[0][i]=='O'){
                map[0][i] = 1;
                helper(board,map,0,i);
            }
        }
        for(int i=0; i<n;i++){
            if(board[m-1][i]=='O'){
                map[m-1][i] = 1;
                helper(board,map,m-1,i);
            }
        }
        for(int i=1; i<m-1;i++){
            if(board[i][0]=='O'){
                map[i][0] = 1;
                helper(board,map,i,0);
            }
        }
        for(int i=1; i<m-1;i++){
            if(board[i][n-1]=='O'){
                map[i][n-1] = 1;
                helper(board,map,i,n-1);
            }
        }
        for(int i=1;i<m-1;i++){
            for(int j=1; j<n-1; j++){
                if(map[i][j]==0)
                    board[i][j] = 'X';
            }
        }
    }
    private void helper(char[][] board, int[][] map, int i, int j){
        if(i+1<m-1 && board[i+1][j]=='O'&&map[i+1][j]!=1){
            map[i+1][j]=1;
            helper(board,map,i+1,j);
        }
        if(j+1<n-1 && board[i][j+1]=='O'&&map[i][j+1]!=1){
            map[i][j+1]=1;
            helper(board,map,i,j+1);
        }
        if(i-1>0 && board[i-1][j]=='O'&&map[i-1][j]!=1){
            map[i-1][j]=1;
            helper(board,map,i-1,j);
        }
        if(j-1>0 && board[i][j-1]=='O'&&map[i][j-1]!=1){
            map[i][j-1]=1;
            helper(board,map,i,j-1);
        }
    }
}
