package com.suku.recursion;

/**
 * Find out sum off all the digits
 */
public class NumberConversion {
    public static void main(String[] args) {
        int n = 7;
        decimalToBinary(n);
    }

    public static void decimalToBinary(int n) {
        if(n == 0) return;
        decimalToBinary(n/2);
        System.out.print(n%2);
    }
}
