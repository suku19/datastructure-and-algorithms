package com.suku.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicateInArray {

    //using storing the reference in map
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current_val = nums[i];
            if (map.containsKey(current_val)) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    //sort the array
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(containsDuplicate1(nums));
    }
}
