package com.suku.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            List<Integer> findElements = getListOfIntegerFromString(line);
            line = in.readLine();
            List<Integer> rotatedList = getListOfIntegerFromString(line);
            rotateListSearch(rotatedList,findElements);
        }
    }

    /**
     * find the elements present or not in the rotated
     * @param rotatedList
     * @param elements
     */
    public static void rotateListSearch(List<Integer> rotatedList, List<Integer> elements) {
        int rotatedIndex = findRotatedIndex(rotatedList, 0, rotatedList.size()-1);
        if(rotatedIndex != -1) {
            rotateArray(rotatedList,rotatedIndex);
        }
        for (int key : elements) {
            int i = binarySearch(rotatedList, 0, rotatedList.size()-1, key);
            System.out.print(i + " ");
        }
    }

    /**
     * Return the index where rotation found. If no rotation found then return -1.
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int findRotatedIndex(List<Integer> nums, int start, int end) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (mid < end && nums.get(mid) > nums.get(mid + 1)) {
            return mid;
        }

        if (mid > start && nums.get(mid) < nums.get(mid - 1))
            return mid - 1;

        if (nums.get(mid) < nums.get(start)) {
            return findRotatedIndex(nums, start, mid - 1);
        } else {
            return findRotatedIndex(nums, mid + 1, end);
        }
    }

    /**
     * rotate array k numbers
     * @param nums
     * @param k
     * @return int[]
     */
    public static List<Integer> rotateArray(List<Integer> nums, int k) {
        int size = nums.size() - 1;
        reverse(nums, 0, size);
        reverse(nums, 0, size - k -1);
        reverse(nums, size - k, size);
        return nums;
    }

    /**
     * reverse array from start to end
     * @param nums
     * @param start
     * @param end
     */
    public static void reverse(List<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }

    /**
     * Return index of element if present else return -1
     * @param records
     * @param low
     * @param high
     * @param key
     * @return int
     */
    public static int binarySearch(List<Integer> records, int low, int high, int key) {
        if(low > high) return -1;

        int mid = low + (high-low)/2;

        if(key == records.get(mid))
            return mid;

        if(records.get(mid) < key) {
            return binarySearch(records, mid+1, high, key);
        } else
            return binarySearch(records, low, mid-1, key);
    }

    /**
     * Convert string to integer array
     * @param line
     * @return int[]
     */
    private static List<Integer> getListOfIntegerFromString(String line) {
        if (Objects.isNull(line) || line.isEmpty()) {
            System.err.println("Input is Empty.");
            throw new RuntimeException("Invalid input");
        }
        try {
            Pattern pattern = Pattern.compile(" ");
            return pattern.splitAsStream(line).map(Integer::valueOf).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.err.println("Input : " + line);
            throw new RuntimeException("Invalid input. Not a valid number.");
        }
    }
}
