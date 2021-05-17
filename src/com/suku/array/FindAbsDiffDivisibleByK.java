package com.suku.array;

public class FindAbsDiffDivisibleByK {
    // function to Count pairs in an array whose
    // absolute difference is divisible by k
    static void countPair(int arr[], int n, int k) {
        // intialize the count
        int cnt = 0;

        // making every element of arr in
        // range 0 to k - 1
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] + k) % k;
        }

        // create an array hash[]
        int hash[] = new int[k];

        // store to count of element of arr
        // in hash[]
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        // count the pair whose absolute
        // difference is divisible by k
        for (int i = 0; i < k; i++) {
            cnt += (hash[i] * (hash[i] - 1)) / 2;
        }

        // print the value of count
        System.out.print(cnt + "\n");
    }

    // Driver Code
    public static void main(String[] args) {
        // input array
        int arr[] = {1, 1, 4, 4};
        int k = 2;

        // calculate the size of array
        int n = arr.length;
        countPair(arr, n, k);
    }
}

