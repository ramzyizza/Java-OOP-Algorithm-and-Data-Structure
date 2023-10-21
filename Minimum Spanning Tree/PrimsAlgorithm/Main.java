package PrimsAlgorithm;

public class Main { 
    public static void main(String[] args) {
        MST mst = new MST(10);
        int[] parent = mst.prev;
        FindOtherST ST = new FindOtherST(10, parent, 39);
        
        System.out.println("\n\nProblem 1 : Implement Graph 8.2.2 into adjacency martrix using prims algorithm");

        int graph[][] = new int[][]{{0,5,0,5,4,0,0,0,0,0},
                                    {5,0,3,0,7,0,6,8,0,0},
                                    {0,3,0,0,0,0,0,0,5,0},
                                    {5,0,0,0,0,4,0,0,0,0},
                                    {4,7,0,0,0,5,0,0,0,0},
                                    {0,0,0,4,5,0,3,0,0,0},
                                    {0,6,0,0,0,3,0,6,0,6},
                                    {0,8,0,0,0,0,6,0,7,0},
                                    {0,0,5,0,0,0,0,7,0,4},
                                    {0,0,0,0,0,0,6,0,4,0}}; 
        mst.primMST(graph);

        System.out.println("\nProblem 2 : Find other possible spanning tree non minimum by moving only one edge only\n");

        ST.nonMinimumST(graph);
        
        System.out.println("\nAll the results from above implementation has been proved using manual calculation given on the lab report\n\n");

    }
}