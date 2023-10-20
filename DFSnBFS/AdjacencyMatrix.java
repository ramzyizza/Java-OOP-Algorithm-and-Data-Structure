package DFSnBFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMatrix {

    int matrix[][];//create new 2d array to represent matrix
    int node; //act as a vertex
    int bound; //bound for matrix length
    LinkedList<Integer> q = new LinkedList<Integer>(); //used on both bfs & dfs

    //create constructor to initialize the 2d array & vertex
    AdjacencyMatrix(int vertex){
        node = vertex;
        matrix = new int[vertex][vertex]; //n x n size
        bound = matrix.length;
    }
    //method to add path/edge from x node to y node
    void addPath(int from, int to){
        //we declare 1 as it is unweighted graph
        matrix[from][to] = 1; 
        matrix[to][from] = 1;
        //declare both from and to vice versa for undirected graph
    }
    void printArray(){
        //print out the 2d array
        for(int u = 0; u < node; u++){
            for(int v  = 0; v < node; v++){
                System.out.print(matrix[u][v] + " ");
            }
            System.out.println(" ");
        }
    }
    //bfs implementation on adjacency matrix
    void bfs(int begin){
        //create array of boolean to insert the start and visisted value
        boolean visit[] = new boolean[bound];
        visit[begin] = true; //declare that it is visited
        q.add(begin);  //enqueue the start value
        //iterate until queue empty
        while(q.size() !=0){
            int head = q.remove(); //pop the head of queue
            System.out.print(head + " ");
            //check if the value of head
            for (int j = 1; j < bound; j++){
                if((matrix[head][j] == 1) && (!visit[j])){
                  q.add(j);
                  visit[j]=true;
                }
            }
        }
    }
    //dfs implementation on adjacency matrix
    void dfs(boolean[] visit, int begin){
        //set the head value to true visited
        visit[begin] = true;
        //push head to the queue
        q.add(begin);
        //itterate using recursive
        for (int i = 0; i < matrix[begin].length; i++) {
            //check if it haven't visited yet & has a direct connection (edge)
            if (matrix[begin][i] == 1 && (!visit[i]))
                dfs(visit, i); //recursion
        }
        //printout the queue until queue is empty
        while(!q.isEmpty()){
            System.out.print(q.pop() + " ");
        }
    }
} 