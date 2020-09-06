# Getting Started with Data Structures and Algorithm

## Array
### Two sum problem

#### Approach 1: Brute Force

> [Implementation of O(n^2) naive Solution](https://github.com/suku19/datastructure-and-algorithms/src/com/suku/array/TwoSum.java)

**Complexity Analysis** :

Time complexity : O(n^2)
For each element, we try to find its complement by looping through the rest of array which takes O(n)O(n) time. Therefore, the time complexity is O(n^2)

Space complexity : O(1).

#### Approach 2: Sort the array and move the index
> [Implementation of O(nlogn) Solution](https://github.com/suku19/datastructure-and-algorithms/src/com/suku/array/TwoSum.java)

**Complexity Analysis** :

Time complexity : O(nlogn). Sort the array which need O(nlogn). Move the index i,j at most n steps which need O(n) time.

Space complexity : O(1). 

#### Approach 3: Two-pass Hash Table
> [Implementation of O(n) Solution](https://github.com/suku19/datastructure-and-algorithms/src/com/suku/array/TwoSum.java)

**Complexity Analysis** :

Time complexity : O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1) time.

Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.

