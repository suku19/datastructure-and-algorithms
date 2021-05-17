package com.suku.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'findNumber' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

    public static String findNumber(List<Integer> arr, int k) {
        // Write your code here
        int start =0, end =arr.size()-1;
        while(start <= end) {
            if(arr.get(start++) == k || arr.get(end--) == k) {
                return "YES";
            }
        }
        return "NO";
    }

}

public class FindTheNumberExistOrNot {
    public static void main(String[] args) throws IOException {

        String result = Result.findNumber(List.of(2, 5, 6, 98,10 ), 8);
        System.out.println(result);
    }
}
