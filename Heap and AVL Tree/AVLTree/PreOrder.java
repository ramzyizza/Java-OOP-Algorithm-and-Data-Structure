package AVLTree;

public class PreOrder {
    void preOrder(Node x){
        if(x != null){
            //Parent - Left Child - Right Child
            System.out.print(x.value + " "); //Parent
            preOrder(x.left); //left 
            preOrder(x.right); //right
        }
        else return;
    }
}