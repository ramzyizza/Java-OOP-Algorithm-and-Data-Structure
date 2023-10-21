package DisjointSet;

import java.util.LinkedList;
import java.util.Queue;

public class DisjointSet {
    Set[] sets;
    int size; 
    Queue<Integer> A,B,C,D,E = new LinkedList<Integer>();

    DisjointSet(int totalSet){ //constructor
        size = totalSet; //set the size = amount of set
        sets = new Set[size + 1]; //declare array with size + 1 (prevent out of bound)
        for(int i = 1; i <= this.size ; i++){
            sets[i] = new Set(i); //makeSet method to create set individually correspond to each data 1 - n
        }
        Queue<Integer> A,B,C,D,E = new LinkedList<Integer>();
    }

    int findSet(int item){ //find method with int paremeters we want to find
        int parent = this.sets[item].getParent(); //get the parent of specific element we want to find

        if(item == parent){ //if element is indeed parent, return itself
            return item;
        }else{ //recursively traverse to root to find the parent
            parent = findSet(parent);
            this.sets[item].setParent(parent); //set the parent 
            return parent; //return the parent
        }
    }

    boolean sameParent(int firstItem, int secondItem){ //check if element x and y has the same parent or not
        return findSet(firstItem) == findSet(secondItem);  //if same element, return true, otherwise false
    }

    void unionByRank(int firstItem, int secondItem){ //union method to merge two set into one
        int firstItemParent = findSet(firstItem); //find the parent of the first element
        int secondItemParent  = findSet(secondItem); //find the parent of the second element

        if(firstItemParent != secondItemParent){ //if parent is different, check the rank first
            int firstRank = this.sets[firstItemParent].getRank(); //return the rank of first subset
            int secondRank = this.sets[secondItemParent].getRank(); //return the rank of second subset

            //we set the highest rank to be the parent, and the lowest rank to be the subset or child
            if(firstRank < secondRank){ 
                this.sets[firstItemParent].setParent(secondItemParent);
            }
            else if(firstRank > secondRank){
                this.sets[secondItemParent].setParent(firstItemParent);
            }
            else{ //if both has equivalent rank, hence we set the parent to be the first one 
                this.sets[secondItemParent].setParent(firstItemParent); //second set's parent is the first set
                this.sets[firstItemParent].setRank(firstRank + 1); //add the rank by 1 
            }
        }
    }

    void printParent(){ //print out the parent of all sets
        for(int i = 1; i <= this.size; i ++){
            System.out.println("Parent of " + i + " = " + findSet(i));
        }
    }

    void printRank(){ //print out the rank of all sets
        for(int i = 1 ; i <= this.size; i ++){
            System.out.println("Rank of " + i + " = " + this.sets[i].getRank());
        }
    }

    void totalSet(){ //return the total sets
        int counter = 1;
        for(int i = 1, j = 2; j <= this.size; i++, j++){
            if(!sameParent(i, j)) //compare before and after parents
                counter++; //if both parent are different, we add counter by 1
        }
        System.out.println("\nTotal Sets = " + counter); //output the counter
    }

    void totalElement(){ //return the total element contained in every sets
        int i, j;
        for (i = 1; i <= this.size; i++) { 
            int counter = 0;
            if (i == this.sets[i].getParent()) { //itterate through set and check if has same parent
                for (j = 1; j <= this.size; j++) {
                    if (i == findSet(j))
                        counter++; //if same i has same parent, increment the counter
                }
                System.out.println("Set " + i + " Total Element : " + counter);
            }
        }
    }
}


