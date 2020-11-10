package com.suku.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This is O(n2)
 */
public class TwoSum {

    // Approach 1: Brute Force
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        int[] result = new int[2];

        outer:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break outer;
                }
            }
        }
        return result;
    }

    // Approach 2: Sort the array and loop through the array and move the first and last index forward and backward based on the sum and compare the sum with target
    public int[] twoSum2(int[] nums, int target) {
        //sort the no arrays and track the index

        int n = nums.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }

        // sort the array based on the a[i][0]
        Arrays.sort(a, (a1, b) -> Double.compare(a1[0], b[0]));

        int i = 0, j = n - 1;

        while (i < j) {
            if (a[i][0] + a[j][0] == target) {
                return new int[]{a[i][1], a[j][1]};
            } else if (a[i][0] + a[j][0] > target) {
                --j;
            } else {
                ++i;
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    // Approach 3: One-pass Hash Table
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        Arrays.stream(new TwoSum().twoSum2(nums, 18)).forEach(a -> System.out.println(a));

    }
}
