## Problem Set

 1. Implement a method to compute the number of sets! For example, for a disjoint-set data structure with 5 data, then S1 = {1}, S2 = {2}, S3 = {3}, S4 = {4}, and S5 = {5}, hence the method will return 5. After performing Union(S3, S4), then S1 = {1}, S2 = {2}, S3 = {3, 4} and S5 = {5}, and hence the method will return 4.
 2. Implement a method to compute the number of elements for each set! In the example in Problem 1, the method will write "S1 has 1 element, S2 has 1 element, S3 has 2 elements, S5 has 1 element".

## CHAPTER 9: Disjoint Set Data Structure

**9.1 Learning Objectives**

1.  Understand the disjoint set data structure.
2.  Solve problems using the disjoint set data structure.

**9.2 Material**

**9.2.1 Disjoint Set**

-   Introduction to the problem of merging items and querying equality.
-   Definition of a disjoint set as a data structure to solve the problem.
-   Concept of disjoint subsets and their non-overlapping nature.
-   Introduction to union and find operations on subsets.
-   Explanation of how to determine if two elements are in the same subset.

**9.2.2 Implementation**

-   Explanation of disjoint-set forests.
-   Detailed steps on how the Find and Union operations work.
-   Example with five disjoint sets and their representation using a tree.
-   Potential issues with naive implementation.
-   Enhancement techniques:
    1.  Union by rank: Attach the smaller tree to the root of the larger tree.
    2.  Path compression: Flatten the tree structure during the Find operation.
-   Importance of both techniques and their impact on operation time.

**9.2.3 Java Implementation**

-   Implementation of the Set class to represent a set in the disjoint-set data structure.
-   Attributes of the Set class: parent and rank.
-   Implementation of the DisjointSet class with find and union methods.
    -   Use of path compression technique in the find method.
    -   Use of union-by-rank technique in the union method.
-   Implementation of the DisjointSetMain class as the main class.