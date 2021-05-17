package com.suku.sort;

public class InsertionSort {

    /**
     *
     * Is data sensitive, total no of step is dependent on data order
     *  - sorted order - > No of comparisons = O(N2)
     *  - reverse order -> No of comparisons = (n*(n-1)/2)
     *  - random order -> O(n2)
     * In place sort, Space complexity O(1)
     * It's stable sort, It not changed the order of duplicate element
     * Efficient when n is small
     * @param a
     */
    public static void insertionSort(int a[]) {
        int i, j, temp, n = a.length-1;
        for( i = 1; i<n; i++) {
            temp = a[i];
            for( j = i-1; j>=0 && a[j]>temp; j--) {
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }
    public static void main(String[] args) {
        int data[] = {3,1,9,3,6,2};
        InsertionSort.insertionSort(data);
        for(int a : data) {
            System.out.print(a + " ");
        }
    }
}
