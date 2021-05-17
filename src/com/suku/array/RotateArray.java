package com.suku.array;

import java.util.Arrays;
import java.util.Random;

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

        System.out.println("First loop : ->");
        Arrays.stream(a).forEach(a1 -> System.out.print(a1 + " "));
        System.out.println();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
        return nums;
    }

    public int[] rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(a -> System.out.print(a + " "));
        reverse(nums, 0, k - 1);
        Arrays.stream(nums).forEach(a -> System.out.print(a + " "));
        reverse(nums, k, nums.length - 1);
        Arrays.stream(nums).forEach(a -> System.out.print(a + " "));
        System.out.println();
        return nums;
    }

    public static void reverse(int[] nums, int start, int end) {
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
        Arrays.stream(new RotateArray().rotate1(nums, 2)).forEach(a -> System.out.print(a + " "));

        // shuffle array
        System.out.println();
        System.out.println("Shuffle array =>");
        display(nums);
        System.out.println();
        shuffleArray(nums);
        display(nums);
    }

    //shuffle an array, make sure every element is not on the previous position
    public static int[] shuffleArray(int a[]) {
        int k = getRandomNumberUsingInts(1, a.length);

        reverse(a, 0, a.length-1);
        reverse(a, 0, k-1);
        reverse(a, k, a.length-1);

        return a;
    }

    public static int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        // the specified origin min is inclusive and max is exclusive.
        return random.ints(min,max).findFirst().getAsInt();
    }

    public static void display(int[] a) {
        Arrays.stream(a).forEach(x -> System.out.print(x +" "));
    }
}
