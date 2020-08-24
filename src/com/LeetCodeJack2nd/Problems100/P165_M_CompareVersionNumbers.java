package com.LeetCodeJack2nd.Problems100;

public class P165_M_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int m1 = strs1.length;
        int m2 = strs2.length;
        int sizeMax;
        sizeMax = Math.max(m1, m2);
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < sizeMax; i++) {
            num1 = (i <= m1 - 1) ? Integer.parseInt(strs1[i]) : 0;
            num2 = (i <= m2 - 1) ? Integer.parseInt(strs2[i]) : 0;
            if (num1 > num2)
                return 1;
            else if (num1 < num2)
                return -1;
        }
        return 0;
    }
}
