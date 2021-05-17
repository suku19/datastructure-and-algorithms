package com.suku.string;

import java.util.LinkedHashSet;

public class RemoveDuplicates {
    // Function to make the string unique
    public static String unique(String s){
        String sb = new String();

        // loop to traverse the string and
        // check for repeating chars using
        // IndexOf() method in Java
        for(int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if c is present in str, it returns
            // the index of c, else it returns -1
            if(sb.indexOf(c) < 0) {
                sb += c;
            }
        }
        return sb;
    }

    // Using linked hashset
    public static String unique1(String s){
        LinkedHashSet<Character> lhs = new LinkedHashSet<>();

        for(Character c: s.toCharArray()) {
            lhs.add(c);
        }
       return lhs.stream().map(String::valueOf).reduce("", (c,n) -> c+n);
    }

    //Using java 8 distinct method
    public static String unique2(String s){
        StringBuilder sb = new StringBuilder();
        s.chars().distinct().forEach(c -> sb.append((char) c));
        return sb.toString();
    }

    // Driver code
    public static void main(String[] args)
    {
        // Input string with repeating chars
        String s = "geeksforgeeks";

        System.out.println(unique1(s));
    }
}
