package DjikstraAlgorithm;

public class Main {
    public static void main(String[] args){
        /* We suppose variable A - I => 0 - 8
        A = 0 | B = 1 | C = 2 | D = 3 
        E = 4 | F = 5 | G = 6 | H = 7 
        I = 8
        */
        int totalVertex = 9;
        Graph graph = new Graph(totalVertex);

        graph.addEdge(0, 1, 10);  //a-b = 10
        graph.addEdge(0, 2, 5);   //a-c = 5
        graph.addEdge(0, 3, 1);   //a-d = 1
        graph.addEdge(1, 2, 4);   //b-c = 4
        graph.addEdge(1, 4, 10);  //b-e = 10
        graph.addEdge(1, 6, 3);   //b-g = 3
        graph.addEdge(2, 4, 10);  //c-e = 10
        graph.addEdge(2, 3, 5);   //c-d = 5
        graph.addEdge(2, 5, 17);  //c-f = 17
        graph.addEdge(3, 5, 16);  //d-f = 16
        graph.addEdge(3, 7, 21);  //d-h = 21
        graph.addEdge(4, 5, 2);   //e-f = 2
        graph.addEdge(4, 6, 2);   //e-g = 2
        graph.addEdge(4, 8, 18);  //e-i = 18
        graph.addEdge(5, 7, 6);   //f-h = 6
        graph.addEdge(5, 8, 15);  //f-i = 15
        graph.addEdge(6, 8, 25);  //g-i = 25
        graph.addEdge(7, 8, 10);  //h-i = 10
        
        System.out.println("Adjacency Matrix Represtation of Undirected Weighted Graph: ");
        graph.printGraph();

        graph.dijkstra(0, 8); //starts from A, ends at I

    }
}
