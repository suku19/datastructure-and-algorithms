package com.suku.string;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class FindPalindrome {
    public static boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = s.length();
        String lcs = s.toLowerCase();
        int left = 0;
        int right = size - 1;
        while(right >= left) {
            boolean isDigitComp = (Character.isDigit(lcs.charAt(right)) && Character.isDigit(lcs.charAt(left)))
                    && (Integer.parseInt(String.valueOf(lcs.charAt(right))) == Integer.parseInt(String.valueOf(lcs.charAt(left))));

            if(lcs.charAt(right) == lcs.charAt(left)) {
                right--;
                left++;
            } else if(!Character.isDigit(lcs.charAt(right)) && !Character.isLetter(lcs.charAt(right))) {
                right--;
            } else if(!Character.isDigit(lcs.charAt(left)) && !Character.isLetter(lcs.charAt(left))) {
                left++;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A 6man88, a plan, a canal: Pa8nam6a"));
    }

}
