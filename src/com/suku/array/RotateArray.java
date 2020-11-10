package com.suku.array;

import java.util.Arrays;

public class RotateArray {

    public int[] rotate(int[] nums, int k) {
        int n = nums.length;
        for (int j = 0; j < k; j++) {
            for (int i = n - 1; i > 0; i--) {
                int t = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = t;
            }
        }
        return nums;
    }

    public int[] rotate1(int[] nums, int k) {
        int a[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
        return nums;
    }

    public int[] rotate2(int[] nums, int k) {
        k %= nums.length;
        System.out.println(k);
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return nums;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Arrays.stream(new RotateArray().rotate2(nums, 8)).forEach(a -> System.out.println(a));
    }
}
