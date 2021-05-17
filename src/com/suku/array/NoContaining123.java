package com.suku.array;
import java.util.*;
public class NoContaining123 {

    public static void main(String[] args) {
        int arr[] = {124,Integer.MAX_VALUE,124,125,14532,126,340,123400,100032,13,32,3123,1100};
        List<Integer>  results  = new ArrayList<>();
        for (int i =0; i<arr.length; i++) {
            int length = (int) (Math.log10(arr[i]) +1);
            if(!(length<3)) {
                if(isFound(String.valueOf(arr[i])))
                    results.add(arr[i]);
            }
        }
        results.stream().forEach(System.out::println);
    }

    public static boolean isFound(String x) {
        return x.contains("123");
    }

    public static boolean isFound(int x) {
        boolean is1Present = false, is2Present = false, is3Present = false;
        while(x>0) {
            int rem = x%10;
            if(rem == 1)
                is1Present = true;
            else {
                if (rem == 2 && is1Present) {
                    is2Present = true;
                } else {
                    is1Present = false;
                }
            }
            if(rem == 3 && is1Present && is2Present)
                is3Present = true;
            else {
                is1Present = false;
                is2Present = false;
            }
            if(is1Present && is2Present && is3Present)
                return true;
            x = x/10;
        }
        return false;
    }

}

