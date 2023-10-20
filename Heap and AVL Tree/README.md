## Problem Set

1. Implement AVL from this chapter with data{0, 1, 2, 3, 4, 5, 6, 7, 8, 9} in sequence. Draw the created AVL Tree! 
2. From the Binary Search Tree implementation from Chapter 3, create one method to check whether the Binary Search Tree is an AVL Tree or not.
3. Create a heap tree for an array with a size of 15 and a data key:
Key = {78, 3, 9, 10, 23, 77, 34, 86, 90, 100, 20, 66, 94, 63, 97}
4. Create a heap sort function to use the heap from this chapter.


## CHAPTER IV: BALANCED TREE: AVL

**4.1 Learning Objectives**

1.  Understand the concept of AVL Tree.
2.  Implement AVL Tree.

**4.2 Materials**

**4.2.1 AVL Tree**

-   Definition and properties of AVL Tree.
-   Examples of AVL and non-AVL Trees.
-   Importance of AVL Trees in ensuring O(log n) operations.

**4.2.2 Insertion**

-   Explanation of AVL Tree balancing during insertion.
-   Basic operations: Left Rotation and Right Rotation.
-   Four cases of rotations: 
	- Left Left Case
	- Left Right Case
	- Right Right Case
	- Right Left Case
-   Steps for AVL Tree insertion.
-   Example scenarios of insertion.
-   Implementation details.

**4.2.3 Deletion**

-   Explanation of AVL Tree balancing during deletion.
-   Basic operations: Left Rotation and Right Rotation.
-   Four cases of rotations:
	- Left Left Case
	- Left Right Case
	- Right Right Case
	- Right Left Case
-   Differences between insertion and deletion in AVL Trees.
-   Example scenarios of deletion.
-   Implementation details.

## CHAPTER V: SORTED TREE: HEAP TREE

**5.1 Learning Objectives**

1.  Understand the concept of the Heap Tree.
2.  Implement Heap Tree.

**5.2 Materials**

**5.2.1 Heap Tree Properties**

-   A heap is a complete binary tree.
-   Each parent node is greater than or equal to its children.
-   Root contains the maximum value.

**5.2.1 Array Implementation**

-   Root is placed at index "1" for easier calculations.
-   Rules for indexing:
    -   Each leftchild is at index 2 * k.
    -   Each rightchild is at index 2 * k + 1.
    -   Parent is at index k / 2.
-   Creation of a node class.
-   Creation of a heap class.

**5.2.2 Insert**

-   New elements are added at the bottom level.
-   Elements are compared to their parent and swapped if necessary.

**5.2.3 Remove**

-   The node with the largest value (root) is deleted.
-   Root is replaced with the lower-right node.
-   The heap property is maintained by repositioning the nodes.

**5.2.4 Print**

-   Values are stored in an array.
-   Displaying the heap tree using the heap property.
