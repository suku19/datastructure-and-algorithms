# Getting Started with Data Structures and Algorithm

## Array
### Two sum problem
```
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
```
#### Approach 1: Brute Force

> [Implementation of O(n^2) naive Solution](https://github.com/suku19/datastructure-and-algorithms/blob/master/src/com/suku/array/TwoSum.java)

**Complexity Analysis** :

Time complexity : O(n^2)
For each element, we try to find its complement by looping through the rest of array which takes O(n)O(n) time. Therefore, the time complexity is O(n^2)

Space complexity : O(1).

#### Approach 2: Sort the array and move the index
> [Implementation of O(nlogn) Solution](https://github.com/suku19/datastructure-and-algorithms/blob/master/src/com/suku/array/TwoSum.java)

**Complexity Analysis** :

Time complexity : O(nlogn). Sort the array which need O(nlogn). Move the index i,j at most n steps which need O(n) time.

Space complexity : O(1). 

#### Approach 3: Two-pass Hash Table
> [Implementation of O(n) Solution](https://github.com/suku19/datastructure-and-algorithms/blob/master/src/com/suku/array/TwoSum.java)

**Complexity Analysis** :

Time complexity : O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1) time.

Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.

### Max Consecutive Ones

```
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
```

> [Implementation of O(n) Solution](https://github.com/suku19/datastructure-and-algorithms/blob/master/src/com/suku/array/FindConsecutiveOnes.java)

**Complexity Analysis** :

Time complexity : O(n). We are moving the index i and maximum n times index can be moved.

### Maximum Product of Three Numbers

```
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:

Input: [1,2,3]
Output: 6
 

Example 2:

Input: [1,2,3,4]
Output: 24
 

Note:

The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
```

> [Implementation of O(nlogn) Solution](https://github.com/suku19/datastructure-and-algorithms/blob/master/src/com/suku/array/MaximumProduct.java)

**Complexity Analysis** :

Time complexity : O(nlogn). Complexity of Arrays.sort is O(nlogn).
