package com.LeetCodeJack2nd;

import com.LeetCodeJack2nd.Problems100.*;
import java.util.*;
public class playGround {

    public static void main(String[] args) {
        P127_M_WordLadder tester = new P127_M_WordLadder();
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
//        String s = "25525511135";
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        tester.ladderLength(beginWord,endWord,wordList);
    }
}
