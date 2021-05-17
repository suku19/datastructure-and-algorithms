package com.suku.array;

public class FindSmalestAndSecondSmalest {

    public static void main(String[] args) {
     int[] a = {};
     findSmalestAndSecondSmalest(a, a.length-1);
    }

    private static void findSmalestAndSecondSmalest(int[] a, int i) {
        int start =0;
        int end = i;
        int s1 = Integer.MAX_VALUE;
        int s2 = Integer.MAX_VALUE;
        while(start<=end) {
            if(a[start] < s1) {
                s2 = s1;
                s1 = a[start++];
            } else if(a[start] < s2)
                s2 = a[start++];
            else if(a[end] < s1) {
                s2 = s1;
                s1 = a[end--];
            } else if(a[end] < s2)
                s2 = a[end--];
            else {
                start++;
                end--;
            }
        }
        System.out.println("Smallest: " + ((s1 == Integer.MAX_VALUE)?-1:s1) + " 2nd Smallest: "+ ((s2 == Integer.MAX_VALUE)?-1:s2));
    }
}
