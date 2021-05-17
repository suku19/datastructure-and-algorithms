package com.suku.array;

import java.util.HashMap;
import java.util.Map;

public class CheckingTwoArrayIsEqual {
    public static void main(String[] args)
    {
        int arr1[] = {2, 3, 5, 5, 2, 2};
        int arr2[] = { 2, 3, 5, 5, 2 };

        if (areEqual(arr1, arr2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    public static boolean areEqual(int arr[],int brr[])
    {
        //Your code here
        if(arr == null && brr == null)
            return true;
        if(arr == null || brr == null || arr.length != brr.length)
            return false;
        if(arr.length == 0)
            return true;

        Map<Integer, Integer> data1 = new HashMap<>();
        // iterate first array and store into the map
        for(int i =0; i< arr.length; i++) {
            if(data1.get(arr[i]) == null)
                data1.put(arr[i], 1);
            else
                data1.put(arr[i], data1.get(arr[i]) + 1);
        }

        // iterate second array and compare
        for(int i =0; i< brr.length; i++) {
            if(!data1.containsKey(brr[i]) || data1.get(brr[i]) < 1)
                return false;
            data1.put(brr[i], data1.get(arr[i]) + 1);
        }
        return true;
    }
}
