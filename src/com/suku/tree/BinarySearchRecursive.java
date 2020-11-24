package com.suku.tree;

public class BinarySearchRecursive {

    public static void main(String[] args) {
        int i, n, searchValue, index;

        int[] arr = {10, 20, 30, 40, 50, 60};

        System.out.println("Index of 40 is: ");
        System.out.println(search(arr, 0, 5, 40));
        System.out.println("Index of 60 is: ");
        System.out.println(search(arr, 0, 5, 60));
        System.out.println("Index of 100 is: ");
        System.out.println(search(arr, 0, 5, 100));


    }

    static int search(int[] arr, int first, int last, int searchValue) {
        if (first > last) {
            return -1;
        }

        int mid = (first + last) / 2;

        if (searchValue < arr[mid]) {
            return search(arr, first, mid - 1, searchValue);
        } else if (searchValue > arr[mid]) {
            return search(arr, mid + 1, last, searchValue);
        } else
            return mid;
    }
}
