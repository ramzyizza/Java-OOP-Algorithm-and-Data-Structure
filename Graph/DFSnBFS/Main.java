package DFSnBFS;

import java.util.Scanner;
import java.lang.Math;

public class Main {
    
    public static void main(String[] args){
        //user determine the size of the adjency matrix
        System.out.print("Input size of 2D array matrix: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        boolean[] visited = new boolean[size];

        //create the object and declare the size of the graph
        AdjacencyMatrix matrix = new AdjacencyMatrix(size);

        System.out.print("Enter amount of value that needs to be inserted: ");
        int insert = sc.nextInt();

        //user input one by one for matrix u and v until n size
        System.out.println("\nEnter the edge [from,to] that correspond to each vertex seperated by spaces: ");
        for(int i = 0; i <= size; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            matrix.addPath(u,v); //insert to the array
        }
        System.out.println( );

        System.out.println("The Graph representation in Ajdacency matrix is: ");
        matrix.printArray();

        System.out.print("\nBFS Algorithm for this graph: ");
        matrix.bfs(0);

        System.out.print("\nDFS Algorithm for this graph: ");
        matrix.dfs(visited, 0);
    }
}
