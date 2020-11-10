package com.suku.string;
// https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueChar {

    public static int firstUniqChar(String s) {
        int[] letters = new int[26];
        // -1 means dup, 0 means non exist, > 0 means the index of non-repeating char
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (letters[c - 'a'] != 0) {
                letters[c - 'a'] = -1;
            } else {
                letters[c - 'a'] = i + 1;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 0) {
                min = Integer.min(min, letters[i] - 1);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabbc"));
        ;
    }
}
