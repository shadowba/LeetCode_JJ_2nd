package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P3_M_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // 用HashMap 记录每个字符的idx，不断移动右指针，一旦遇见出现过的字符，更新HashMap的idx并且左指针移动以达到将window 中移除重复字符的作用
        Map<Character, Integer> idxMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int N = s.length();
        if (N == 0)
            return 0;
        char c;
        for (int i = 0; i < N; i++) {
            c = s.charAt(i);
            if (idxMap.containsKey(c))
                left = Math.max(left, idxMap.get(c) + 1);
            maxLength = Math.max(maxLength, i - left + 1);
            idxMap.put(c, i);
        }
        return maxLength;
    }
}
