package com.suku.sort;

public class QuickSort {

    /**
     * Time complexity of Quick Sort is  θ(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the array into two halves and takes linear time to merge two halves.
     * Auxiliary Space: O(1)
     *
     * @param a
     * @param l
     * @param r
     */


    static void sort(int a[], int l, int r) {
        if(l < r) {
            // find the middle point
            int pivot = partition1(a, l, r); //Version 1
            //int pivot = partition(a, l, r); // version 2

            //Sort the first and second half
            sort(a, l, pivot-1);
            sort(a, pivot+1, r);
        }
    }

    /**
     * Partition using leaner for loop
     * @param a
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] a, int l, int r) {
        // first element as pivot
        int pivot  = a[l];
        int smallIndex = l;
        for(int i=l+1; i<=r; i++) {
            //if current element is smaller
            if(a[i] < pivot) {
                smallIndex++;
                swap(a, smallIndex, i);
            }
        }
        swap(a, 0, smallIndex);

        return smallIndex;
    }

    /**
     * Partition using two pointer while loop
     * @param a
     * @param l
     * @param r
     * @return
     */
    private static int partition1(int[] a, int l, int r) {
        int i = l+1, //move from left to right
                j = r, // move from right to left
                pivot = a[l];

        while(i<=j) {
            while(i <= r && a[i] < pivot)
                i++;
            while(a[j] > pivot)
                j--;
            if(i<j) {
                swap(a,i++,j--);
            }else // found proper place for pivot
                break;
        }

        //Proper place for pivot is j
        a[l] = a[j];
        a[j] = pivot;
        return j;
    }

    public final static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int a[] = {50, 45, 20, 10, 43,83, 74, 68, 85, 60, 89, 71};

        sort(a,0, a.length-1);

        for (int i : a) {
            System.out.println(i + " ");
        }
    }
}
