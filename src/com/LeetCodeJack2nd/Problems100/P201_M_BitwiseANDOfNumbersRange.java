package com.LeetCodeJack2nd.Problems100;

public class P201_M_BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0)
            return 0;
        int mask = Integer.MAX_VALUE;
        while ((m & mask) != (n & mask)) {
            mask <<= 1;
        }
        return m & mask;
    }
}
