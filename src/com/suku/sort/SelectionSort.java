package com.suku.sort;

public class SelectionSort {

    /**
     * Order of complexity O(N2) => Total no pass (n*(n-1)/2)
     * Is not data sensitive, total no of step is not dependent on data order
     * In place sort, Space complexity O(1)
     * It's unstable sort, It might changed the order of duplicate element
     *
     * @param a
     */
    public static void selectionSort(int a[]) {
        for(int i = 0; i<a.length-1; i++) {
            int minIndex = i;
            for (int j =i+1; j<a.length;j++) {
                if(a[minIndex] > a[j])
                    minIndex = j;
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
    public static void main(String[] args) {
        int data[] = {3,1,9,3,6,2};
        SelectionSort.selectionSort(data);
        for(int a : data) {
            System.out.print(a + " ");
        }
    }
}
