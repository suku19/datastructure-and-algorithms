package com.suku.array;

import java.util.Arrays;

public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        //step 1 - sort the array
        Arrays.sort(nums);

        //step 2 - find the p1 and p2
        int p1, p2, n;
        n = nums.length;
        p1 = nums[n - 3] * nums[n - 2] * nums[n - 1];
        p2 = nums[0] * nums[1] * nums[n - 1];

        //step 3 - return the max of p1 and p2
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new MaximumProduct().maximumProduct(nums));
    }
}
