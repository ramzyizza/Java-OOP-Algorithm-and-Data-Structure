package AVLTree;
import java.util.*;

public class Main{
    public static void main(String[]args){
        AVLTree AVL = new AVLTree();
        PreOrder order = new PreOrder();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Input size of data: ");
        int size = sc.nextInt();
        System.out.print("Input " + size + " amount of data seperated by spaces: ");

        for(int i = 0;i < size; i++){
            int input = sc.nextInt();
            AVL.root = AVL.insertion(AVL.root, input); //Construct AVL Tree - Balanced
            AVL.addNode(new Node(input)); //Construct Binary Search Tree - Unbalanced
        }
        //Question 1
        System.out.println("\n[After] Constructured AVL Tree written in Preorder Traversal is:  ");
        order.preOrder(AVL.root);        
        //Question 2
        System.out.println("\n" + AVL.checkUnbalance(AVL.root)); //Check AVL Tree

        System.out.println("\n[Before] Regular Binary Search Tree written in Preorder Traversal is:  ");
        order.preOrder(AVL.root2);
        //Question 2
        System.out.println("\n" + AVL.checkUnbalance(AVL.root2)); //Check Binary SearchTree
    }
}