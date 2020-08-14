package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P36_M_ValidSudoku {
    Map<Integer, Set<Character>> rowMap;
    Map<Integer, Set<Character>> colMap;
    Map<Integer, Set<Character>> blockMap;
    public boolean isValidSudoku(char[][] board) {
        rowMap = new HashMap<>();
        colMap = new HashMap<>();
        blockMap = new HashMap<>();
        for(int i =0; i<board.length; i++){
            for(int j = 0; j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(rowMap.get(i)==null){
                        rowMap.put(i, new HashSet<>());
                        rowMap.get(i).add(board[i][j]);
                    }
                    else{
                        if(rowMap.get(i).contains(board[i][j]))
                            return false;
                        rowMap.get(i).add(board[i][j]);
                    }

                    if(colMap.get(j)==null){
                        colMap.put(j, new HashSet<>());
                        colMap.get(j).add(board[i][j]);
                    }
                    else{
                        if(colMap.get(j).contains(board[i][j]))
                            return false;
                        colMap.get(j).add(board[i][j]);
                    }

                    if(blockMap.get((i/3)*3+j/3)==null){
                        blockMap.put((i/3)*3+j/3, new HashSet<>());
                        blockMap.get((i/3)*3+j/3).add(board[i][j]);
                    }
                    else{
                        if(blockMap.get((i/3)*3+j/3).contains(board[i][j]))
                            return false;
                        if(blockMap.get((i/3)*3+j/3).add(board[i][j]));
                    }
                }
            }
        }
        return true;
    }
}
