package com.suku.array;

public class FindConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int max_l = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int r = i + 1;
                int current_l = 1;
                while (r < n && nums[r] == 1) {
                    ++current_l;
                    ++r;
                }
                i = r;
                max_l = Math.max(max_l, current_l);
            }
        }
        return max_l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(new FindConsecutiveOnes().findMaxConsecutiveOnes(nums));

    }
}
