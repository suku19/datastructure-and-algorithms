package com.suku.string;

import java.util.*;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class Anagram {

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
    public static boolean isAnagram1(String s, String t) {
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

    //Approach #3 (Hash Table)
    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())
            return false;

        HashMap<Character, Integer> hash = new HashMap<>();

        for (int i=0; i< s.length(); i++) {
            Character chs = s.charAt(i);
            Character cht = t.charAt(i);

            hash.put(chs, hash.getOrDefault(chs,0)+1);
            hash.put(cht, hash.getOrDefault(cht,0)-1);

        }

        for(Map.Entry<Character, Integer> es : hash.entrySet()) {
            if(es.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    //find all the anagram
    static List<String> anagramResult = new ArrayList<>();
    public static List<String> createAnagram(String str, int start, int end) {
        if(start ==  end) {
            anagramResult.add(str);
        } else{
            for(int i = start; i<=end; i++) {
                str = swap(str,start,i);
                createAnagram(str,start+1,end);
                str = swap(str,start,i);
            }
        }
        return anagramResult;
    }

    public static String swap(String a, int i, int j)
    {
        char [] charArr = a.toCharArray();
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;
        return String.valueOf(charArr);
    }

    public static void main(String[] args) {
        String s1 = "Cat";
        String s2 = "taC";
        System.out.println(s1 +" and " + s2 +" is anagram => " + isAnagram2(s1,s2));

        // find all the unique anagram of a given string
        String findAnagram = "asdfghjklp";
        String uniqueString = RemoveDuplicates.unique1(findAnagram);
        System.out.println(createAnagram(uniqueString, 0, uniqueString.length()-1).size());
    }

}
