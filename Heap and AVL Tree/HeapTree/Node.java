package HeapAssignment;

public class Node {
    private String data; //input flight data
    private int prior; //priority number data

    public Node(int key, String flight){
        prior = key;
        data = flight;
    }
    public int getKey(){
        return prior;
    }
    public String getData(){
        return data;
    }
}
