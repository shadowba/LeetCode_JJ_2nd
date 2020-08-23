package com.LeetCodeJack2nd;

import com.LeetCodeJack2nd.Problems100.*;
import java.util.*;
public class playGround {

    public static void main(String[] args) {
        P134_M_GasStation tester = new P134_M_GasStation();
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
//        String s = "25525511135";
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        int[] gas = {1,2,3,4,5};
        int[] cost ={3,4,5,1,2};
        tester.canCompleteCircuit(gas,cost);
    }
}
