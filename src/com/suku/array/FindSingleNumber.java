package com.suku.array;

import java.util.*;

public class FindSingleNumber {

    //Option 1:  O(n2) solution
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }

        return set.iterator().next();
    }

    public static int singleNumber4(int[] nums) {
       Map<Integer, Integer> store = new HashMap<>();

       for(int num : nums) {
            store.put(num, store.getOrDefault(num, 0)+1);
       }

       for (int i : nums) {
            if (store.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }

    //Option2: sort an array, nlogn solution
    public static int singleNumber1(int[] nums) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length;

        while (start < end) {
            if (start == end - 1) {
                return nums[start];
            }
            if (nums[start] != nums[start + 1]) {
                return nums[start];
            }
            start += 2;
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //Option 3: Bit Manipulation, O(n) solution
    public int singleNumber3(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        System.out.println(singleNumber4(nums));
    }
}
