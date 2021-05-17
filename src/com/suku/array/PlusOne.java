package com.suku.array;

import java.util.Arrays;
// https://leetcode.com/problems/plus-one/
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // filter from the end of the array
        for (int i = n - 1; i >= 0; i--) {
            // if current element is less than 9 then add one to that element and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // else set the current element to 0
            digits[i] = 0;
        }

        // for all 9 i.e. {9,9} -> {1,0,0}
        int[] newdigits = new int[n + 1];
        newdigits[0] = 1;
        return newdigits;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9};
        Arrays.stream(plusOne(nums)).forEach(a -> System.out.print(a + " "));

        System.out.println();
        int[] nums1 = {1,2,3};
        Arrays.stream(plusOne(nums1)).forEach(a -> System.out.print(a + " "));
    }
}

