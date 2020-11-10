package com.suku.string;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {

    public static int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        int result = 0;
        if (s.length() == 0) return 0;

        //Discard whitespaces in the beginning
        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        // Check if optional sign if it exists
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            sign = (s.charAt(i++) == '-') ? -1 : 1;

        // Build the result and check for overflow/underflow condition
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(i++) - '0');
        }
        return result * sign;

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }
}

