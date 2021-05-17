package com.suku.tree;

public class FindElementInRotatedBinaryTree {

    public static int pivotedBinarySearch(int arr[],int n, int key) {

        int pivot = findRotatedIndex(arr, 0, n-1);
        System.out.println("Pivoted Index" + pivot);

        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, n - 1, key);

        // If we found a pivot, then first
        // compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, n - 1, key);
    }

    public static int binarySearch(int[] a, int low, int high, int key) {
        if(low > high) return -1;

        int mid = low + (high-low)/2;

        if(key == a[mid])
            return mid;

        if(a[mid] < key) {
            return binarySearch(a, mid+1, high, key);
        } else
            return binarySearch(a, low, mid-1, key);
    }

    public static int findRotatedIndex(int a[], int start, int end) {
        //
        if(start > end) return -1;

        int mid = start + (end-start)/2;

        if(mid < end && a[mid] > a[mid+1]) {
            return mid;
        }

        if(mid > start && a[mid] < a[mid-1])
            return mid-1;

        if(a[mid] < a[start]) {
            return findRotatedIndex(a, start, mid-1);
        } else {
            return findRotatedIndex(a, mid+1, end);
        }
    }

    public static void main(String[] args) {
        // Let us search 3 in below array
        int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int n = arr1.length;
        int key = 1;
        System.out.println("Index of the element is : "
                + pivotedBinarySearch(arr1, n, key));
    }
}
