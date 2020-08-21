package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P93_M_RestoreIPAddresses {
    List<String> resList;

    public List<String> restoreIpAddresses(String s) {
        resList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(s, 0, sb);
        return resList;
    }

    private void helper(String s, int sec, StringBuilder sb) {
        if (s.equals("") && sec == 4) {
            resList.add(sb.substring(0,sb.length()-1));
            return;
        }else if(s.length()>0 && sec>=4)
            return;
        int num = 0;

        if (s.length() >= 1) {
            num = s.charAt(0) - '0';
            if (0 <= num && num <= 9) {
                sb.append(s.substring(0,1) + ".");
                helper(s.substring(1), sec + 1, sb);
                sb.delete(sb.length() - 2, sb.length());
            }
        }

        if (s.length() >= 2) {
            num = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
            if (10 <= num && num <= 99) {
                sb.append(s.substring(0,1) + s.substring(1,2) + ".");
                helper(s.substring(2), sec + 1, sb);
                sb.delete(sb.length() - 3, sb.length());
            }
        }

        if (s.length() >= 3) {
            num = (s.charAt(0) - '0') * 100 + (s.charAt(1) - '0') * 10 + (s.charAt(2) - '0');
            if (100 <= num && num <= 255) {
                sb.append(s.substring(0,1) + s.substring(1,2) + s.substring(2,3)+ ".");
                helper(s.substring(3), sec + 1, sb);
                sb.delete(sb.length() - 4, sb.length());
            }
        }
    }
}
