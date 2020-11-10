package com.suku.string;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    // Approach 1: Horizontal scanning
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];

        for(int i=1; i<strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    //Approach 2: Vertical scanning
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";

        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(int j=1; j < strs.length; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    // Driver Code
    public static void main(String[] args) {
        String [] arr = {"leetcode", "leetex","le"};
        System.out.println(longestCommonPrefix1(arr));
    }
}
