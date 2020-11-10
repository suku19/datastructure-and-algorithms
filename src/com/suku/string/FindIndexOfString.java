package com.suku.string;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FindIndexOfString {

    public static int strStr(String haystack, String needle) {
        if(needle == "")
            return 0;

        int index = haystack.indexOf(needle);
        return index;
    }

    public static void main(String[] args) {
        System.out.println(strStr("abababc", "bc"));
    }
}
