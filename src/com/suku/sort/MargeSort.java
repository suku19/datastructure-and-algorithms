package com.suku.sort;

public class MargeSort {

    /**
     * Time complexity of Merge Sort is  θ(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the array into two halves and takes linear time to merge two halves.
     * Auxiliary Space: O(n)
     *
     * @param a
     * @param l
     * @param m
     * @param r
     */
    public static void marge(int [] a, int l, int m, int r) {
        // find the size of two sub array to be merged
        int n1 = m-l+1;
        int n2 = r-m;

        //create temp array
        int [] la = new int[n1];
        int [] ra = new int[n2];

        //Copy data to temp array
        for(int i=0; i < n1; ++i)
            la[i] = a[l+i];
        for(int j=0; j < n2; ++j)
            ra[j] = a[m+1+j];

        /*Marge sub array*/
        int i =0, j=0, k=l;
        //Initial index
        while(i <n1 && j<n2) {
            if(la[i] <= ra[j]) {
                a[k++] = la[i++];
            } else {
                a[k++] = ra[j++];
            }
        }

        //copy remaining in la if any
        while(i < n1) {
            a[k++] = la[i++];
        }

        //copy remaining in ra if any
        while(j < n2) {
            a[k++] = ra[j++];
        }
    }

    static void sort(int a[], int l, int r) {
        if(l < r) {
            // find the middle point
            int mid = l + (r-l)/2;

            //Sort the first and second half
            sort(a, l, mid);
            sort(a, mid+1, r);

            //marge the sorted half
            marge(a,l, mid, r);
        }
    }

    public static void main(String[] args) {
        int a[] = {5, 1, 3, 8, 10, 7, 9};

        sort(a,0, a.length-1);

        for (int i : a) {
            System.out.println(i + " ");
        }
    }
}
