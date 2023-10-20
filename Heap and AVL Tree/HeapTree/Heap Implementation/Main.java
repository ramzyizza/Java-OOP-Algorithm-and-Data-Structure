package HeapASD;

public class Main {
    
    public static void main(String[]args){
        Heap heap = new Heap(15);

        heap.insert(78);
        heap.insert(3);
        heap.insert(9);
        heap.insert(10);
        heap.insert(23);
        heap.insert(77);
        heap.insert(34);
        heap.insert(86);
        heap.insert(90);
        heap.insert(100);
        heap.insert(20);
        heap.insert(66);
        heap.insert(94);
        heap.insert(63);
        heap.insert(97);
    
        heap.displayHeap();
    }

}
