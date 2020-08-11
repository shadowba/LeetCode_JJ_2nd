package com.LeetCodeJack2nd.Problems100;

public class P5_M_LongestPalindromicSubstring {
//    马拉车算法（ Manacher‘s Algorithm
//    https://zhuanlan.zhihu.com/p/88299272

    public String longestPalindrome(String s) {
        String str = buildBorder(s);
        int N = str.length();
        int centerIdx = 0;
        int maxRightIdx = 0;
        int[] p = new int[N]; // store radius value, i itself excluded.
        int mirrorIdx = 0;
        int maxSubLength = 0;
        int originalIdxStart = 0;
        int originalIdx = 0;
        for (int i = 0; i < N; i++) {
            if (maxRightIdx - i > 0) {
                mirrorIdx = 2 * centerIdx - i;
                p[i] = Math.min(p[mirrorIdx], maxRightIdx - i);
            }
            int left = i - p[i] - 1;
            int right = i + p[i] + 1;
            while (left >= 0 && right < N && str.charAt(left) == str.charAt(right)) {
                p[i]++;
                left--;
                right++;
            }
            if (i + p[i] > maxRightIdx) {
                maxRightIdx = i + p[i];
                centerIdx = i;
            }
            if (p[i] > maxSubLength) {
                originalIdx = i / 2;
                originalIdxStart = originalIdx - p[i] / 2;
                maxSubLength = p[i];
            }

        }
        return s.substring(originalIdxStart, originalIdxStart + maxSubLength);
    }

    private String buildBorder(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        if (n == 0)
            return "";
        sb.append("#");
        for (int i = 0; i < n; i++)
            sb.append(s.charAt(i) + "#");
        return sb.toString();
    }
}
