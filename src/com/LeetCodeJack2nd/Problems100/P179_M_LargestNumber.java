package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P179_M_LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        stringComparator comp = new stringComparator();
        StringBuilder sb = new StringBuilder();
        String[] s_nums = new String[nums.length];

        for (int i = 0; i < nums.length; i++)
            s_nums[i] = String.valueOf(nums[i]);

        Arrays.sort(s_nums, comp);

        if (s_nums[0].charAt(0) == '0')
            return "0";

        for (String str : s_nums) {
            sb.append(str);
        }
        return sb.toString();
    }

    private class stringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            String num1 = s1 + s2;
            String num2 = s2 + s1;
            return num2.compareTo(num1);
        }
    }
}
