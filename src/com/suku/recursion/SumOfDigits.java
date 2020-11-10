package com.suku.recursion;

/**
 * Find out sum off all the digits
 */
public class SumOfDigits {
    public static void main(String[] args) {
        int n = 11111;
        System.out.println(sumDigits(n));
    }

    public static int sumDigits(int n) {
        if(n/10 == 0) return n;
        return sumDigits(n/10) + n%10;
    }
}
