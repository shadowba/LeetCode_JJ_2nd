package com.LeetCodeJack2nd.Problems100;

public class P6_M_ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int gap1 = (numRows - 2) * 2 + 1;
        int gap2 = 0;
        int next1 = 0;
        int next2 = 0;
        int N = s.length();
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        int count = 1;
        for (int i = 0; i < numRows; i++) {
            if (i >= N)
                break;

            count = 1;
            next1 = 0;
            next2 = 0;
            cur = i;

            if (i == 0 || i == numRows - 1)
                gap2 = 0;
            else
                gap2 = gap1 - i * 2;


            while (next1 < N && next2 < N) {
                sb.append(s.charAt(cur));
                next2 = cur + (gap2 + 1);
                if (i != 0 && i != numRows - 1 && next2 < N) {
                    sb.append(s.charAt(next2));
                }

                next1 = cur + (gap1 + 1);
                cur = next1;
            }
        }
        return sb.toString();
    }
}
