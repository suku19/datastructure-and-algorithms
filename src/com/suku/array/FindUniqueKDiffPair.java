package com.suku.array;

import java.util.HashMap;
import java.util.Map;

public class FindUniqueKDiffPair {

    //using storing the reference in map
    public static int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i : nums) {
            if (map.containsKey(i)) {
                if (k == 0 && map.get(i) == 1) {
                    map.put((i+k)%k, map.get(i) + 1);
                    res++;
                }
                continue;
            }
            res += map.getOrDefault(i + k, 0);
            res += map.getOrDefault(i - k, 0);
            map.put((i+k)%k , 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 4};

        System.out.println(findPairs(nums, 2));
    }
}
