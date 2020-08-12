package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P12_M_IntegerToRoman {
    public String intToRoman(int num) {
        if (num == 0)
            return "";
        String[] symb = {"M", "D", "C", "L", "X", "V", "I"};
        int[] div = {1000, 500, 100, 50, 10, 5, 1};
        int res = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < div.length; i += 2) {
            res = num / div[i];
            if (res == 0)
                continue;
            if (1 <= res && res <= 3) {
                for (int j = 0; j < res; j++)
                    sb.append(symb[i]);
            } else if (4 <= res && res <= 5) {
                String str = (res == 4) ? (symb[i] + symb[i - 1]) : symb[i - 1];
                sb.append(str);
            } else if (6 <= res && res <= 8) {
                sb.append(symb[i - 1]);
                res -= 5;
                for (int j = 0; j < res; j++)
                    sb.append(symb[i]);
            } else {
                sb.append(symb[i] + symb[i - 2]);
            }
            num %= div[i];

        }
        return sb.toString();
    }
}
