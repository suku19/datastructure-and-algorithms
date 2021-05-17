package pattern.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * Example 2:
 *
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};

        System.out.println(findMaxSumSubArray(arr, 3));
    }

    private static int findMaxSumSubArray(int[] arr, int k) {
        int start=0, end=0, maxSum=0,windowSum =0, n = arr.length;

        while(end<n) {
            windowSum+=arr[end];

            // if sub array length is
            if(end-start > k-1) {
                windowSum-=arr[start];
                start++;
            }
            maxSum = Math.max(windowSum,maxSum);
            end++;
        }
        return maxSum;
    }
}
