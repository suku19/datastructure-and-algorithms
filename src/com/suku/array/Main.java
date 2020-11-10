package com.suku.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {

    // if key is present return index, otherwise returns -1
    static int search(int arr[], int l, int h, int key) {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;

        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return search(arr, mid + 1, h, key);
        }

        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarry*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);

        return search(arr, l, mid - 1, key);
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            int[] findIndex = getInts(line);
            line = in.readLine();
            int[] actualArray = getInts(line);
            Arrays.sort(actualArray);
            int n = actualArray.length;
            for (int key : findIndex) {
                int i = search(actualArray, 0, n - 1, key);
                System.out.print(i + " ");
            }

        }
    }

    private static int[] getInts(String line) {
        if (null == line || line.isEmpty()) {
            System.out.println("Input is Empty.");
            throw new RuntimeException("Invalid input");
        }
        try {
            return Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            System.out.println("Input : " + line);
            throw new RuntimeException("Invalid input. Not a valid number.");
        }
    }

    //1 11 7
    //62 78 99 1 5 7 11 13 17 27

}


