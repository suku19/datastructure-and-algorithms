package com.suku.numeric;

import java.util.Arrays;

public class FindPrimeNumber {

    //Approach 1:
    static void printPrimeNumber(int n) {
        // iterate all the number from
        for (int i = 1; i <= n; i++) {
            if(isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    static boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    //Approach 2
    //https://www.geeksforgeeks.org/sieve-of-eratosthenes/
    //time complexity of Sieve of Eratosthenes is n*log(log(n)) - https://www.geeksforgeeks.org/how-is-the-time-complexity-of-sieve-of-eratosthenes-is-nloglogn/
    // Space complexity is O(n)
    // https://www.youtube.com/watch?v=yB57bcffJo4&ab_channel=CodingBlocks
    static void sieveOfEratosthenes(int n) {
        // initially assume all integers are prime
        //Assign all the elements of boolean array to true
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor * factor <= n; factor++)
        {
            // If prime[factor] is not changed, then it is a prime
            if (prime[factor] == true)
            {
                // Update all multiples of p
                for (int i = factor * factor; i <= n; i += factor)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++)
        {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        printPrimeNumber(100);
        System.out.println();
        sieveOfEratosthenes(-100);
    }

}
