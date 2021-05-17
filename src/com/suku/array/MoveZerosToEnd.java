package com.suku.array;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
public class MoveZerosToEnd {

    // Two pointer solution(j -> slow mover and i -> fast mover). Swap the non zero element and keep a track of it
    public static int[] moveZeroes(int[] nums) {
        int j = 0;
        // shift non zero to first
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }

        // shift zero to the last
//        int j=nums.length-1;
//        for(int i=nums.length-1; i>=0; i--) {
//            if(nums[i] == 0) {
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j--] = temp;
//            }
//        }

        return nums;
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        Arrays.stream(moveZeroes(nums)).forEach(a -> System.out.println(a));

    }
}
