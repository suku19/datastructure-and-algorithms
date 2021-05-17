package com.suku.array;

import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDupSortedArray {

    //Two pointer solution. i is slow mover and j is fast mover.
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        Arrays.stream(nums).forEach(a -> System.out.print(a +" "));
        System.out.println();
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDupSortedArray().removeDuplicates(nums));
    }
}
