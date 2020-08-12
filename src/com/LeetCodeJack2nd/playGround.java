package com.LeetCodeJack2nd;

import com.LeetCodeJack2nd.Problems100.*;
import java.util.*;
public class playGround {

    public static void main(String[] args) {
        P139_M_WordBreak tester = new P139_M_WordBreak();
        String input = "applepenapple";
        List<String>wordDict = new ArrayList<>(Arrays.asList("apple", "pen"));
        tester.wordBreak(input,wordDict);
    }
}
