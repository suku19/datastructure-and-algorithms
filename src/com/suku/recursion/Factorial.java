package com.suku.recursion;

import java.util.Scanner;

public class Factorial {

    public static long factorial(int n) {
        if(n==0) return 1;
        return  n * factorial(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.println("Enter a number greater than or equal to zero : ");

        n = sc.nextInt();
        System.out.println(factorial(n));
    }
}
