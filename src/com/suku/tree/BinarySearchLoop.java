package com.suku.tree;

public class BinarySearchLoop {

    public static void main(String[] args) {
        int i, n, searchValue, index;

        int[] arr = {10, 20, 30, 40, 50, 60 };

        System.out.println("Index of 40 is: ");
        System.out.println(search(arr, 6, 40));


    }

    static int search(int[] arr, int n, int searchValue) {
        int first = 0, last = n-1, mid;
        while( first <= last ) {
            mid = (first+last)/2;
            if(searchValue < arr[mid]) {
                last = mid-1;
            }else if(searchValue > arr[mid]) {
                first = mid + 1;
            } else
                return mid;
        }

        return -1;
    }
}
