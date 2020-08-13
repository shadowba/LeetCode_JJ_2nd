package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P22_M_GenerateParentheses {
    int N;
    List<String> resList;

    public List<String> generateParenthesis(int n) {
        this.N = n;
        resList = new ArrayList<>();
        if (n == 0)
            return resList;
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        helper(sb, 1, 0);
        return resList;
    }

    private void helper(StringBuilder sb, int prevNum, int backNum) {
        if (prevNum + backNum == 2 * N) {
            resList.add(sb.toString());
            return;
        }

        char ch = sb.charAt(sb.length() - 1);

        if (prevNum < N || prevNum == backNum) {
            sb.append('(');
            helper(sb, prevNum + 1, backNum);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (backNum < N && prevNum > backNum) {
            sb.append(')');
            helper(sb, prevNum, backNum + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
