package com.suku.array;

import java.util.Arrays;

public class MoveZerosToEnd {

    // Two pointer solution(j -> slow mover and i -> fast mover). Swap the non zero element and keep a track of it
    public static int[] moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        Arrays.stream(moveZeroes(nums)).forEach(a -> System.out.println(a));

    }
}
