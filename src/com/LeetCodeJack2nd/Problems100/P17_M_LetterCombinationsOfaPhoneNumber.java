package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P17_M_LetterCombinationsOfaPhoneNumber {
    Map<Character, List<String>> map;
    List<String> resList;

    public List<String> letterCombinations(String digits) {
        resList = new ArrayList<>();
        if(digits == null || digits.length()==0)
            return resList;

        map = new HashMap<>();
        char[] nums = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        map.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        helperDFS(nums, sb, 0);
        return resList;
    }

    private void helperDFS(char[] nums, StringBuilder sb, int idx) {
        if (idx == nums.length) {
            resList.add(sb.toString());
            return;
        }
        for (String str : map.get(nums[idx])) {
            sb.append(str);
            helperDFS(nums, sb, idx+1);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
