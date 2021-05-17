package com.suku.string;

/**
 * https://leetcode.com/problems/count-and-say/
 */
public class RunLengthEncoding {

    public static String countEncoding(String s) {
        if (s.length() <= 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        int count =1;
        for(int i =1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            } else {
                sb.append(s.charAt(i-1));
                sb.append(count);
                count = 1;
            }
        }

        sb.append(s.charAt(s.length()-1));
        sb.append(count);

        return sb.toString();
    }

    // Driver Code
    public static void main(String[] args) {
        String N = "aabbcc";
        System.out.println("Input => " + N +",  Output => "+countEncoding(N));

        N = "abjkdliiwww..,,@@!!hh";
        System.out.println("Input => " + N +",  Output => "+countEncoding(N));

    }
}
