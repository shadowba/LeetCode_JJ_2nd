package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P150_M_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        if (tokens.length == 0)
            return 0;
        int num1 = 0;
        int num2 = 0;
        int res = 0;

        Set<String> operators = new HashSet<>(Arrays.asList("+","-","*","/"));
        for (String token : tokens) {
            if(operators.contains(token)){
//            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                num2 = stack.pop();
                num1 = stack.pop();
                switch (token.charAt(0)) {
                    case '+':
                        res = num1 + num2;
                        break;
                    case '*':
                        res = num1 * num2;
                        break;
                    case '-':
                        res = num1 - num2;
                        break;
                    case '/':
                        res = num1 / num2;
                        break;
                    default:
                        break;
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
