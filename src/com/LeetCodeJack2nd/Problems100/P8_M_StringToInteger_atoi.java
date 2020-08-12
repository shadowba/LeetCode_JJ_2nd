package com.LeetCodeJack2nd.Problems100;

public class P8_M_StringToInteger_atoi {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;

        String numStr = str.trim();
        if (numStr == null || numStr.length() == 0)
            return 0;
        System.out.println(numStr);
        int N = numStr.length();
        char[] chArr;
        chArr = numStr.toCharArray();

        int res = 0;
        int num;

        int flag = (chArr[0] == '-') ? -1 : 1;
        int start = 0;
        if (chArr[0] == '-' || chArr[0] == '+')
            start = 1;

        int limit = Integer.MAX_VALUE / 10;

        for (int i = start; i < N; i++) {
            num = chArr[i] - '0';
            if (num > 9 || num < 0)
                return res*flag;
            if (res < limit)
                res = res * 10 + num;
            else if (res > limit && i <= N - 1) {
                res = (flag == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                return res;
            } else if (res == limit && i == N - 1) {
                if ((flag == -1 && num <= 8) || (flag == 1 && num <= 7))
                    res = res * 10 + num;
                else {
                    res = (flag == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    return res;
                }
            }
        }
        if (flag == -1 && res > 0)
            res *= -1;
        return res;
    }
}
