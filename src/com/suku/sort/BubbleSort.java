package com.suku.sort;

public class BubbleSort {

    /**
     *
     * Is data sensitive, total no of step is dependent on data order
     *  - sorted order - > No of comparisons = (N-1) and then no swaps
     *  - reverse order -> No of comparisons = (n*(n-1)/2)
     *  -random order -> O(n2)
     * In place sort, Space complexity O(1)
     * It's stable sort, It not changed the order of duplicate element
     *
     * @param a
     */
    public static void bubbleSort(int a[]) {
        int n = a.length-1, swaps;
        for(int i = 0; i<n-1; i++) {
            swaps=0;
            for (int j =0; j<n-i;j++) {
                if(a[j+1] < a[j]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swaps++;
                }
            }
            if(swaps==0)
                break;
        }
    }
    public static void main(String[] args) {
        int data[] = {3,1,9,3,6,2};
        BubbleSort.bubbleSort(data);
        for(int a : data) {
            System.out.print(a + " ");
        }
    }
}
