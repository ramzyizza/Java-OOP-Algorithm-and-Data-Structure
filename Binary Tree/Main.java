package BinaryTree;


import java.util.*;

public class Main {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        //Receive input from user
        System.out.print("Enter desired size you want to insert: "); 
        int input = sc.nextInt();
        System.out.print("\nInput data seperated by spaces: ");
        //Itterate to insert data
        for(int i = 0; i < input; i++){
            int j = sc.nextInt();
            bt.addNode((new Node(j)));
        }

        //1. Implement binary search and searching algorithm
        System.out.println("PROBLEM 1:");
        System.out.print("Input data element you want to search: ");
        int find = sc.nextInt();
        System.out.println(BinaryTree.searchValue(bt.root, find));

        //2. User choose which traversal order
        System.out.println("PROBLEM 2: ");
        System.out.println("Choose type of traversal you want: ");
        System.out.println("1. Inorder \n2. Preorder \n3. Postorder\n");
        int choose = sc.nextInt();

        if(choose == 1){
            System.out.println("Inorder = Left Child - Parent - Right Child");
            BinaryTree.inorder(bt.root);
        }
        else if(choose == 2){
            System.out.println("\nPreorder =  Parent - Left Child - Right Child");
            BinaryTree.preorder((bt.root));
        }
        else if(choose == 3){
            System.out.println("\nPostorder: Left Child - Right Child - Parent");
            BinaryTree.postorder(bt.root);
        }
        else{
            System.out.println("\nWrong input");
        }
        
        //3. Sum up all the value inside the binary tree
        System.out.println("\n\nPROBLEM 3: ");
        System.out.print("The total sum of data inside the binary tree is: " + BinaryTree.sumValue(bt.root));
        
        //4. Display the maximum height of the binary tree
        System.out.println("\n\nPROBLEM 4: ");
        System.out.print("The height of the binary tree is: " + (BinaryTree.getHeight(bt.root)-2));

        //5. display nodes based on it's depth of level in binary tree
        System.out.println("\n\nPROBLEM 5: ");
        System.out.println("Display nodes value based on it's level: ");
        BinaryTree.showLevelOrder(bt.root);

        //6. display sibling's value of certain node in same level
        System.out.println("\n\nPROBLEM 6: ");
        System.out.print("Enter desired value to check it's sibling's value: ");
        int checkSibling = sc.nextInt();
        Node siblingNode = bt.displaySibling(bt.root, checkSibling);
        if(siblingNode != null)
            System.out.println("It's Sibling: " + siblingNode.value);
        else 
            System.out.println("No Sibling");
        //check if it has sibling or not
        System.out.print("\n\nInput FIRST value to check if it has siblings: ");
        int findSibling1 = sc.nextInt();
        System.out.print("Input SECOND value to check if it has siblings: ");
        int findSibling2 = sc.nextInt();

        if (BinaryTree.nodeSibling(bt.root, findSibling1, findSibling2))
            System.out.print("It has the same parents or a sibling ");
        else
            System.out.print("It's neither sibling nor has the same parents");

    }
}   
