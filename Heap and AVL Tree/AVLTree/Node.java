package AVLTree;


public class Node{ //used for constructing the AVL Tree and BST
    int value, height;
    Node left, right;
    Node(int x){
        height = 1;
        value = x;
    }
    public int getValue(){
        return value;
    }
}



