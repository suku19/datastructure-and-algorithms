package com.suku.string;

/**
 * Problem statement https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    // The entire logic for reversing a string is based on using the opposite directional two-pointer approach!
    public static char[] reverseString(char[] s) {
        if(s==null || s.length == 0)
            return s;

        int start_p = 0;
        int end_p = s.length-1;

        while(start_p < end_p) {
            char tmp = s[start_p];
            s[start_p++] = s[end_p];
            s[end_p--] = tmp;
        }
        return s;
    }

    // reverse a string using recursion method
    public static String reverseString(String s) {

        return helperRecursion(s);
    }

    private static String helperRecursion(String s) {
        if (s.length() <= 1){
            return s;
        }

        return helperRecursion(s.substring(1))+ s.charAt(0);
    }


    public static void main(String[] args) {
        char s[] = {'a', 'b', 'c'};
        System.out.println(reverseString(s));
        System.out.println(reverseString("abc"));
    }
}
