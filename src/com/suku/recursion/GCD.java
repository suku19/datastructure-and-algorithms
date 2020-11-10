package com.suku.recursion;

public class GCD {

    public static void main(String[] args) {
        int n = 11111;
        System.out.println(gcd(8,4));
    }

    public static float gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b,a%b);
    }
}
