package com.suku.recursion;

public class NthPower {

    public static void main(String[] args) {
        int n = 11111;
        System.out.println(nthPower(2,5));
    }

    public static float nthPower(float x, int n) {
        if(n == 0) return 1;
        return x * nthPower(x,n-1);
    }
}
