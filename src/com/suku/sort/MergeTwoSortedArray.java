package com.suku.sort;

public class MergeTwoSortedArray {
    public static void mergeSort(int a[],int b[], int temp[]) {
        int i=0, j=0, k=0, n1 = a.length, n2 = b.length;

        while(i <= n1-1 && j <= n2-1) {
            if(a[i] < b[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = b[j++];
            }
        }

        while(i <= n1-1) {
            temp[k++] = a[i++];
        }

        while(j <= n2-1) {
            temp[k++] = b[j++];
        }

    }

    public static void main(String[] args) {
        int a[] = {5,7,9};
        int b[] = {1,3,8,10};
        int temp[] = new int[((a.length) + (b.length))];

        MergeTwoSortedArray.mergeSort(a,b,temp);

        for(int i: temp) {
            System.out.println(i + " ");
        }
    }
}
