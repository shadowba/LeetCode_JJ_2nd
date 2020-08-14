package com.LeetCodeJack2nd.Problems100;

public class P43_M_MultiplyStrings {
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        int num = 0;
        int carry = 0;
        int p1 = 0, p2 = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                p1 = i + j;
                p2 = i + j + 1;
                num = res[p2] + num;
                res[p2] = num % 10;
                res[p1] = num / 10 + res[p1];
            }
        }
        for (int p : res) {
            if (sb.length() == 0 && p == 0)
                continue;
            sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
