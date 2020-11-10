package com.suku.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArray {

    // using sorted array, no extra memory is required
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList();
        int j = 0;
        int i = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
                result.add(nums2[j++]);
            }
        }
        return listToArray(result);
    }

    //Using a hashmap
    public static int[] intersect1(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null || nums1.length==0  || nums2.length==0)
            return new int[0];

        // step1: Put elements in nums1 into the map
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums1)
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);

        // step 2: iterate the nums2 and get the result
        List<Integer> result = new ArrayList<>();

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0)
            {   result.add(num);
                int freq = map.get(num);
                freq--;
                map.put(num, freq);
            }
        }

        return listToArray(result);
    }

    private static int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {2, 7, 12, 15};
        System.out.println("3/2 = "+ 3/2);
        Arrays.stream(intersect(nums1, nums2)).forEach(a -> System.out.println(a));

    }
}
