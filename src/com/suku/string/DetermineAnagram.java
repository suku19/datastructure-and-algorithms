package com.suku.string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class DetermineAnagram {

    //Approach 1 - Sort the array
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        char str1[] = s.toCharArray();
        char str2[] = t.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1,str2);
    }

    //Approach #2 (Hash Table)
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length())
            return false;

        int alpha[] =  new int[26];

        for(int i=0; i<s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }

        for(int count: alpha) {
            if(count > 0){
                return false;
            }
        }

        return true;
    }


}
