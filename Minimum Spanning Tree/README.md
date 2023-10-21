## Problem Set

 1. Test the code with the graph from 8.2.2 and modify the code such that it also calculate the total cost of the MST. Did you get the same result compared to the theoretical one? 
 2. Another spanning tree (non-minimum) can be created from an MST by changing the edge connections. Write a program that output the number of spanning trees that can be created by changing the position of one edge only. Then, among these new spanning trees, output the minimum cost. Test your code on the graph from 8.2.2. Check the correctness by comparing the result with the one performed through manual calculation

## CHAPTER 8: Minimum Spanning Tree Problem with Prim's Algorithm

**8.1 Learning Objectives**

1.  Implement Prim’s algorithm to solve minimum spanning tree problem.

**8.2 Material**

**8.2.1 Minimum Spanning Tree Problem**

-   Definition of a spanning tree.
-   Difference between a graph and a tree.
-   Concept of minimum spanning tree (MST) in weighted graphs.
-   Mention of two algorithms to solve MST: Kruskal and Prim. Focus on Prim’s algorithm.

**8.2.2 Prim’s Algorithm**

-   Step-by-step working of Prim’s algorithm.
-   Application of Prim’s algorithm on a weighted graph example.
-   Explanation of selecting edges and avoiding cycles.
-   Resulting MST from the example with a total cost.

**8.2.3 Java Implementation of Prim’s Algorithm**

-   Assumption of graph representation using adjacency matrix.
-   Use of `mstSet` array to track vertices included in MST.
-   Initial key values setup for vertices.
-   Basic idea of code execution:
    1.  Pick a vertex not in `mstSet` with minimum key value.
    2.  Include the vertex in `mstSet`.
    3.  Update key values of all adjacent vertices.
-   Mention of `minKey` and `printMST` methods.
-   Explanation of `primMST` method.
-   Reference to the main method.