package com.LeetCodeJack2nd.Problems100;

public class P151_M_ReverseWordsInAString {
    public String reverseWords(String s) {
        if(s.length()==0)
            return "";
        s = s.trim();
        String[] strArr = s.split("");
        StringBuilder sb = new StringBuilder();
        for(String str:strArr){
            if(str.equals(" "))
                continue;
            sb.insert(0,str+" ");
        }
        return sb.toString().trim();
    }
}
