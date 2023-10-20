package HeapTree;

public class Heap {
    static Node[] heap; //heap implemented on array
    private static int sizeMax; //bound for array
    private static int size; //current size of heap array
    //set constructor for heap
    public Heap(int max){
        sizeMax = max;
        size = 0;
        heap = new Node[sizeMax +1]; //declare size of heap
    }
    public static boolean isFull(){
        return size == sizeMax; //if size == maxInput, return true
    }
    //Insertion method
    public static boolean insert(int prior, String flight){ //receive 2 data, priority and flight data
        if(isFull())
            return false; //base case
        Node newNode = new Node(prior, flight); //create new node
        size++; //increase the size
        heap[size] = newNode;
        trickleUp(size); //recursive
        return true;
    }
    public static void trickleUp(int index){
        int parent = index/2; 
        Node last = heap[index]; //last data on bottom == last index
        while(index > 1 && last.getKey() > heap[parent].getKey()){ //trickle up the biggest value to the root
            heap[index] = heap[parent]; 
            index = parent;
            parent = index/2;
        }
        heap[index] = last;
    }
    public void trickleDown(int index){
        int maxChild;
        Node head = heap[index];
        
        while(size >= 2*index){  //trickle down to make max value to the top
            int leftC = 2*index;
            int rightC = leftC +1;

            if(size >= 2*index + 1 && heap[leftC].getKey() < heap[rightC].getKey()) //go to right if right > left
                maxChild = rightC;
            else
                maxChild = leftC;
            if(head.getKey() >= heap[maxChild].getKey()) //if the root > child, then break the loop
                break;
                
            heap[index] = heap[maxChild];
            index = maxChild;
        }
        heap[index] = head;
    }
    public Node maxHeadNode(){ //return the value of max (root) and perform deletion of max
        Node head = heap[1];
        heap[1] = heap[size];
        trickleDown(1);
        size--;
        return head;
    }   

}