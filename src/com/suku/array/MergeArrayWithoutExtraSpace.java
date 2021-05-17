package com.suku.array;

import java.util.Arrays;

public class MergeArrayWithoutExtraSpace {
    public static int nextGap(int gap) {
        if(gap <= 1)
            return 0;

        return (gap/2 + (gap%2) );
    }

    /**
     * We start comparing elements that are far from each other rather than adjacent.
     * For every pass, we calculate the gap and compare the elements towards the right of the gap.
     * Every pass, the gap reduces to the ceiling value of dividing by 2.
     * The time complexity of this method is O((N+M)log(N+M)) and space complexity is O(1).
     * @param arr1
     * @param arr2
     * @param n
     * @param m
     */
    public static void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int i, j, gap = (n+m);


        for(gap = nextGap(gap); gap>0; gap = nextGap(gap)){

            // compare first array
            for(i=0; i+gap < n; i++) {
                if(arr1[i] > arr1[i+gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i+gap];
                    arr1[i+gap] = temp;
                }
            }

            //compare in both array
            for(j = gap>n ? gap-n : 0; i<n && j<m; i++,j++) {
                if(arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
            //compare in second array
            if(j<m) {
                for(j=0; j+gap<m; j++) {
                    if(arr2[j] > arr2[j+gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j+gap];
                        arr2[j+gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * We will traverse the first array and compare it with the first element of the second array.
     * If the first element of the second array is smaller than the first array then we will swap and then sort the second array.
     *
     * First we have to traverse the array1 and then compare with the first element of array2.
     * If it is less than array1 then swap we swap both.
     *
     * After swaping we are going to sort the array2 again so that smallest element of the array2
     * comes at first position and we can again swap with the array1
     * To sort the array2 we will store the first element of array2 in a variable and and left shift all the element and store
     * the first element in array2 in the last.
     *
     * Time Complexity: O(n*m)
     * Space Complexity: O(1)
     *
     */

    public static void merge1(int arr1[], int arr2[], int n, int m) {
        //traverse the first array
        for(int i=0; i<n; i++) {
            //compare with first element and swap
            if(arr1[i]>arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }

            // sort the second array
            int j, firstElement = arr2[0];
            for(j=1; j<m && arr2[j] < firstElement; j++) {
                arr2[j-1] = arr2[j];
            }
            arr2[j-1] = firstElement;
        }
    }


    // Driver Code
    public static void main(String[] args)
    {
        int[] arr1 = { 1, 3, 5, 7 };

        int[] arr2 = { 0, 2, 6, 8, 9 };
        merge1(arr1, arr2, arr1.length, arr2.length);

        Arrays.stream(arr1).forEach(System.out::print);
        Arrays.stream(arr2).forEach(System.out::print);
    }


}
