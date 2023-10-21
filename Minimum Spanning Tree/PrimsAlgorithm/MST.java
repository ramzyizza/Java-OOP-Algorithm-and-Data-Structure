package PrimsAlgorithm;

public class MST {
    public int cost;
    int V, prev[], value[], mstWeight = 0;
    boolean MSTset[];
    
    MST(int vertex) {
        prev = new int[vertex];
        V = vertex;
    }

    public int minKey() {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int v = 0;
        while(v != V){
            if(MSTset[v] == false && value[v] < min){
                min = value[v];
                minIndex = v;
            }
            v++;
        }
        return minIndex;
    }

    public void printMST(int graph[][]) {
        System.out.println("Edge \tWeight");
        mstWeight = 0;
        for(int i = 1; i < V; i++) {
            System.out.println((prev[i] + 1) + " - " + (i + 1) + "\t" + graph[i][prev[i]]);
            mstWeight += graph[i][prev[i]];
        }
        System.out.println("Total weight of the MST : " + mstWeight);
        cost = mstWeight;
    }

    public void primMST(int graph[][]) { 
        value = new int[V];
        MSTset = new boolean[V];

        for(int i = 0; i < V; i++) {
            value[i] = Integer.MAX_VALUE;
            MSTset[i] = false;
        }
        value[0] = 0;
        prev[0] = -1;

        for(int i = 0; i < V - 1; i++) {
            int u = minKey();
            MSTset[u] = true;
            for(int v = 0; v < V; v++) {
                if(graph[u][v] != 0 && MSTset[v] == false && graph[u][v] < value[v]) {
                    prev[v] = u;
                    value[v] = graph[u][v];
                }
            }
        }
        printMST(graph);
    }
}