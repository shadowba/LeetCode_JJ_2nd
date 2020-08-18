package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P71_M_SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        if(path.equals("")||path.length()==0)
            return "/";

        Stack<String> stack = new Stack<>();
        String[] pathArr = path.split("/");
        for(String p: pathArr){
            if(p.equals(".")||p.equals(""))
                continue;
            else if(p.equals("..")){
                if(stack.isEmpty())
                    continue;
                else
                    stack.pop();
            }
            else{
                stack.push(p);
            }
        }
        if(stack.isEmpty())
            return "/";
        while(!stack.isEmpty())
            sb.insert(0,"/"+stack.pop());
        return sb.toString();
    }
}
