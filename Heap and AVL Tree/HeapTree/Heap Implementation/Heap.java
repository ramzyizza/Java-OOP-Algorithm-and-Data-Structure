package HeapASD;

public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;
    //constructor
    public Heap(int mx){
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize + 1];
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }
    public boolean isFull(){
        return currentSize == maxSize;
    }
    public boolean hasLeftChild(int index){
        return 2*index <= currentSize;
    }
    public boolean hasRightChild(int index){
        return 2*index + 1 <= currentSize;
    }
    //insert method
    public boolean insert(int key){
        if(isFull()){
            return false;
        }
        Node newNode = new Node(key);
        currentSize++;
        heapArray[currentSize] = newNode;
        trickleUp(currentSize);
        return true;
    }
    //trickling up
    public void trickleUp(int index){
        int parent = index/2;
        Node bottom = heapArray[index];

        while(index > 1 && heapArray[parent].getKey() < bottom.getKey()){
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = index/2;
        }
        heapArray[index] = bottom;
    }
    //remove the head
    public Node remove(){
        Node root = heapArray[1];
        heapArray[1] = heapArray[currentSize];
        currentSize--;
        trickleDown(1);
        return root;
    }
    //trickling down
    public void trickleDown(int index){
        int largerChild;
        Node top = heapArray[index];

        while(hasLeftChild(index)){
            int leftChild = 2*index;
            int rightChild = leftChild + 1;

            if(hasLeftChild(index) && heapArray[rightChild].getKey() > heapArray[leftChild].getKey()){
               largerChild = rightChild;
            }
            else{
                largerChild = leftChild;
            }
            if(top.getKey() >= heapArray[largerChild].getKey()){
                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }
    //print out all the element
    public void displayHeap(){
        System.out.print("Heap Array: ");
        for (int i = 1;i <=currentSize; i++){
            System.out.print(heapArray[i].getKey() + " ");
        }
        System.out.println(" ");
    }
}
