package com.suku.array;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeating {

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 9, 3, 9, 7, 7, 4 };
        int n = arr.length;
        System.out.println(firstNonRepeating(arr, n));
    }

    private static Integer firstNonRepeating(int[] arr, int n) {
        // Insert all array elements in hash
        // table
        Map<Integer, Integer> store = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            if (store.get(arr[i]) == null) {
                store.put(arr[i], 1);
            } else
                store.put(arr[i], store.get(arr[i]) + 1);
        }

        // Traverse through map only and
        // using for-each loop for iteration over Map.entrySet()
        for(Map.Entry<Integer, Integer> x: store.entrySet())
        if(x.getValue() == 1)
            return x.getKey();

        return null;
    }
}
