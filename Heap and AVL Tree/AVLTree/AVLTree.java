package AVLTree;


public class AVLTree {
    //root 1 = AVL Tree | root 2 = Binary Search Tree
    Node root, root2;

    //return the height of tree
    int height(Node n){ 
        if(n == null) //check if the root has element or not
            return 0;
        return max(height(n.left), height(n.right)) + 1;
    }
    //return the max value of given integers
    int max(int a, int b){ 
        if(a > b) return a; 
        else return b;      
    }
     //single right rotation algorithm
    Node singleRight(Node a){
        Node b = a.left;  //set the left child
        Node t = b.right; //set the right child

        b.right = a;  //rotation process
        a.left = t;

        //max method to update the height value of new tree with respect to y and x
        a.height = max(height(a.left), height(a.right)) + 1; 
        b.height = max(height(b.left), height(b.right)) + 1;

        return b; //return the updated value
    }
    //single left rotation algorithm 
    Node singleLeft(Node b){ 
        Node a = b.right; //set the right child
        Node t = a.left; //set the left child

        a.left = b; //rotation process
        b.right = t;

        //max method to update the height value of new tree with respect to y and x
        b.height = 1 + max(height(b.left), height(b.right));
        a.height = 1 + max(height(a.left), height(a.right));

        return a; //return the updated value
    }
    //inserting value to AVL Tree
    Node insertion(Node n, int data){ 
        if(n == null) return (new Node(data)); //if theres no root, then create new AVL tree
        if(data < n.value) //if the inserted value is smaller then go left
            n.left = insertion(n.left, data); //repeat
        else if (data > n.value) //if inserted value is greater then go right
            n.right = insertion(n.right, data); //repeat
        else
            return n; //return the node
        
        n.height = 1 + max(height(n.left), height(n.right)); //computer the total height

        int balance = balanceFactor(n); //invoke balance factor and set to the balance variable

        //check to determine which rotation algorithm
        if(balance > 1 && data < n.left.value) //if balance factor +2 use single right rotation
            return singleRight(n); //left child is unbalanced
        if (balance < -1 && data > n.right.value) //if balance factor -2 use single left rotation
            return singleLeft(n); //right child is unbalanced
        //double rotation
        if(balance > 1 && data > n.left.value){ //if balance factor +2 and has different operator (-+)
            n.left = singleLeft(n.left); //implement double rotation
            return singleRight(n);
        }
        if(balance < -1 && data < n.right.value){ //if balance factor +2 and has different operator (-+)
            n.right = singleRight(n.right); //implement double rotation
            return singleLeft(n);
        }
        return n; //return updated AVL Tree
    }
    //compute the balance factor algorithm (left child & right child)
    int balanceFactor(Node n){ 
        if(n == null) return 0; //if tree empty, return 0
        return height((n.left)) - height(n.right); //else, get the balance factor of nodes 
    }
    //check AVL Tree or not
    String checkUnbalance(Node n){
        if(balanceFactor(n) > 1) //if balance factor +2
            return "It is Unbalanced on LHS of BST"; 
        else if (balanceFactor(n) < -1) //if balance factor -2
            return "It is Unbalanced on RHS of BST";
        else
            return "It is Balanced BST / AVL Tree"; //if balance factor -1 < x < 1
    }
    //Regular binary search tree data insertion method
    void addNode(Node n){
        if(root2 == null) //if tree empty, create a new root
            root2 = n; //set as root
        else
            insertNode(root2, n); //create as a child
    }
    void insertNode(Node parent, Node n){
        if(n.getValue() < parent.getValue()){ //if data < parent, go left
            if(parent.left == null) //if parent left null
                parent.left = n; //insert the data
            else
                insertNode(parent.left, n); //traverse to the left
        }
        else{
            if(parent.right == null) //if parent right null
                parent.right = n; //insert the data
            else
                insertNode(parent.right, n); //traverse to the right
        }
    }
}