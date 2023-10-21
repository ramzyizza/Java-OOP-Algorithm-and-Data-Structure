package DisjointSet;

public class Set {

    int parent; //value of root node
    int rank; //value of rank set
    
    Set(int data){ //constructor
        this.parent = data; //initialize the data as the parent(representatives)
        this.rank = 0; //the rank still 0 since it doesnt has any child
    }

    int getParent(){
        return this.parent; //method to return the parent of an element
    }

    void setParent(int parent){
        this.parent = parent; //method to set the parent of an element 
    }

    int getRank(){
        return this.rank; //method to return the rank of a subset
    }

    void setRank(int rank){
        this.rank = rank; //method to set the rank of a subset
    }
}
