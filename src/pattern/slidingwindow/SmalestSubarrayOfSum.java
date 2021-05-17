package pattern.slidingwindow;

/**
 * Given an array arr[] consisting of N integers, the task is to find the length of the smallest subarray with sum equal to K.
 *
 * Examples:
 *
 * Input: arr[] = {2, 4, 6, 10, 2, 1}, K = 12
 * Output: 2
 * Explanation:
 * All possible sub arrays with sum 12 are {2, 4, 6} and {10, 2}.
 *
 * Input: arr[] = { 1, 2, 4, 3, 2, 4, 1 }, K = 7
 * Output: 2
 *
 * Time Complexity::
 * The time complexity of the above algorithm will be O(N). The outer while loop runs
 * for all elements and the inner while loop processes each element only once,
 * therefore the time complexity of the algorithm will be O(N+N) which is
 * asymptotically equivalent to O(N).
 *
 * Space Complexity::
 * The algorithm runs in constant space O(1)O(1).
 */
public class SmalestSubarrayOfSum {

    private static int findLength(int[] a, int x) {
        int start=0, end=0, windowSum=0, n = a.length, minLength = n+1;

        while(end < n) {
            windowSum +=a[end];

            while (windowSum >= x) {
                minLength = Math.min(minLength, end - start + 1);
                windowSum-= a[start++];
            }
            end++;
        }


//        while(end< n) {
//            //if currentSum < x add sum
//            while(currentSum<=x && end < n)
//                currentSum += a[end++];
//
//            //if currentSum > x remove
//            while(currentSum > x && start<n) {
//
//                // update min length if needed
//                if(end-start < minLength)
//                    minLength = end-start;
//
//                // remove the starting element
//                currentSum-=a[start++];
//            }
//        }

        return minLength;
    }

    public static void main(String[] args) {
        int a[] = {2, 4, 6, 10, 2, 1};
        int x  =  12;

        System.out.println(findLength(a, x));
    }
}
