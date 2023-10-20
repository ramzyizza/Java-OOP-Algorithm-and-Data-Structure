package BinaryTree;

import java.util.*;

public class BinaryTree {
    public Node root;

    //Creating node for tree - Problem 1
    public void addNode(Node node){
        if(root == null)
            root = node;
        else
            insertNode(root, node);
    }

    //Data insertion method - Problem 1
    public void insertNode(Node parent, Node node){
        if(node.getValue() < parent.getValue()){
            if(parent.leftC == null)
                parent.leftC = node;
            else
                insertNode(parent.leftC, node);
        }
        else{
            if(parent.rightC == null)
                parent.rightC = node;
            else
                insertNode(parent.rightC, node);
        }
    }

    //Binary search algorithm - Problem 1
    public static String searchValue(Node root, int value){
        if(root == null)
            return "\nData Not Found\n";
        else{
            if(root.getValue() == value)
                return "\nData Found!\n";
            else if(root.getValue() > value)
                return searchValue(root.leftC, value);
            else
                return searchValue(root.rightC, value);
        }
    }  

    //In-order algorithm - Problem 2
    public static void inorder(Node root) {
        if(root != null){
            inorder(root.leftC);
            System.out.print(root.value + " ");
            inorder(root.rightC);
        }
    }

    //Pre-order algorithm - Problem 2
    public static void preorder(Node root){
        if(root!= null){
            System.out.print(root.value + " ");
            preorder(root.leftC);
            preorder(root.rightC);
        }
    }

    //Post-order algorithm - Problem 2
    public static void postorder(Node root) {
        if(root != null){
            postorder(root.leftC);
            postorder(root.rightC);
            System.out.print(root.value + " ");
        }
    }

    //Calculate sum of all value in BST algorithm - Problem 3
    public static int sumValue(Node root){
        int sumLeft = 0,sumRight = 0,total = 0;
        if (root != null){
            if(root.leftC != null)
                sumLeft = sumValue(root.leftC);
            if(root.rightC != null)
                sumRight = sumValue(root.rightC);
            total = root.value + sumLeft + sumRight;
        }
        return total;
    }

    //Calculate the highest depth of a binary tree algorithm - Problem 4
    public static int getHeight(Node root){
        int rightHeight = 0, leftHeight = 0;
        int height;
        if(root!=null){
            if(root.leftC != null)
                leftHeight = getHeight(root.leftC);
            if(root!=null)
                rightHeight = getHeight(root.rightC);
        }
        if(leftHeight > rightHeight)
            height = leftHeight+1;
        else
            height = rightHeight+1;

        return height;
    } 

    //Display all the value of nodes based on depth levels algorithm - Problem 5
    public static void showLevelOrder(Node root){
        //check the data is null or not
        if (root == null){
            System.out.println("There are no such data contain inside the binary Tree!");
            return;
        }
        //implement queue to push all the value to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root); //node value
        queue.add(null); //eliminator
        //loops until all queue is empty
        while (queue.isEmpty() == false) {
            root = queue.poll(); //remove first element and return
            if (root == null) { //check if the next node is occurs
                if (queue.isEmpty() == false) {
                    queue.add(null);
                    System.out.println();
                }
            }
            else {
                if (root.leftC != null)
                    queue.add(root.leftC); //push left child
                if (root.rightC != null)
                    queue.add(root.rightC); //push right child
                System.out.print(root.value + "  ");
            }
        }
    }
    //Display sibling's value with given node algorithm - Problem 6
    public Node displaySibling(Node root, int data) {
        if(root.value == data || root == null) 
            return null; //tree is empty
        Node parentNode = null;
        
        while(root != null) {
            if(root.value > data) {
                parentNode = root;
                root = root.leftC;
            } 
            else if(root.value < data) {
                parentNode = root;
                root = root.rightC;
            } 
            else
            break;
        }

        if(parentNode.leftC.value == data && parentNode.leftC != null)
            return parentNode.rightC;
        if(parentNode.rightC.value == data && parentNode.rightC != null)
            return parentNode.leftC;
        return null;
    }  

    public Node insert(Node root, int data) {
        if(root == null) 
            return createNewNode(data);
        if(root.value > data)
            root.leftC = insert(root.leftC, data);
        else if((root.value < data))
            root.rightC = insert(root.rightC, data);
        return root;
    }

    public Node createNewNode(int i) {
        Node rootNew = new Node();
        rootNew.leftC = null;
        rootNew.rightC = null;
        rootNew.data = i;

        return rootNew;
    }

    //Check if the given data has a sibling or not - Problem 6
    public static boolean nodeSibling(Node root,int data1, int data2){
        if (root == null)
            return false;
        if (root.rightC != null && root.leftC != null){
            int rightSide = root.rightC.value;
            int leftSide = root.leftC.value;
        if (rightSide == data2 && leftSide == data1)
            return true;
        else if (rightSide == data1 && leftSide == data2)
            return true;
        }
        if (root.leftC != null) //check left side
            nodeSibling(root, data1, data2);
        if (root.rightC != null) //check right side
            nodeSibling(root, data1, data2);
        return true;  
    }
} 