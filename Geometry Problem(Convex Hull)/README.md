## Problem Set

1. Add getConvexHullArea method in the Geometry class that takes input of the convex hull of a set of points S, CH(S), and return the area of the area enclosed by the convex hull. 
2. Add getConvexHullLength method in the Geometry class that takes input of the convex hull of a set of points S, CH(S), and return the perimeter of the convex hull.

## CHAPTER 11: Geometry Algorithm (Convex Hull Problem)

**11.1 Learning Objectives**

1.  Understand the concept of convex hull.
2.  Understand the monotone chain algorithm for convex hull.
3.  Solve problems related to convex hull.

**11.2 Material**

**11.2.1 Convex Hull**

-   Definition: The smallest convex polygon encompassing a set of points.
-   Intuitive explanation using the analogy of nails on a board surrounded by a rubber band.
-   Overview of various algorithms for finding the convex hull.

**11.2.2 The Monotone Chain Algorithm**

-   Introduction: Sorting points lexicographically and constructing the convex hull.
-   Explanation of the lower and upper hulls.
-   Detailed step-by-step example:
    -   Starting with sorted points in 2D space.
    -   Building the lower hull.
    -   Building the upper hull.
    -   Merging the two hulls into a single convex hull.
-   Visual representation of the process with color-coded segments.

**11.2.3 Java Implementation**

-   Introduction to the `Point` class:
    -   Attributes: x and y (both of type double).
    -   Implementation of the `Comparable` interface with the `compareTo` method.
-   Introduction to the `Geometry` class:
    -   Static methods: `cross`, `ccw`, and `convexHull`.
    -   Functionality: Cross product calculation, determining counter-clockwise turn, and building the convex hull.
-   Introduction to the `GeometryMain` class for the main program execution.