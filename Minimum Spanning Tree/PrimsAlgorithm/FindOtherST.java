package PrimsAlgorithm;

public class FindOtherST {

    int V, mstWeight, findMinimumCost; 
    int prev[];
    boolean connect;

    FindOtherST(int V, int previous[], int mstWeight){
        this.V = V;
        connect = false;
        prev = previous;
        this.mstWeight = mstWeight;
    }
    
    public void nonMinimumST(int adjacencyMatrix[][]) {
        int totalSpanningTree = 2, i = 0, j = 0, k = 0;
        int temp[] = new int[V];
        findMinimumCost = mstWeight++;

        while(i != V){
            temp = prev.clone();
            temp[i] = -1;
            for(j = 0; j < V; j++) {
                for(k = 0; k < V; k++) {
                    if(temp[k] == -1 || adjacencyMatrix[i][j] == adjacencyMatrix[k][prev[k]] || adjacencyMatrix[i][j] == 0)
                        continue;
                    else if(adjacencyMatrix[i][j] == adjacencyMatrix[k][prev[k]])
                        continue;
                    else if(adjacencyMatrix[i][j] == 0)
                        continue;
                    else{
                        if(isConnect(i, j, 0, temp)) {
                            totalSpanningTree++;
                            if(findMinimumCost > mstWeight + 1 && mstWeight - adjacencyMatrix[i][prev[i]] + adjacencyMatrix[i][j] <= findMinimumCost) {
                                findMinimumCost = mstWeight + adjacencyMatrix[i][prev[i]] - adjacencyMatrix[i][j];
                            }
                        }
                    }
                    
                }
            }
            i++;
        }
        System.out.println("Among all spanning trees with total of "+ (int)(totalSpanningTree+1) + " that had\nbeen form from moving one edge, there exist one spanning tree that has minimum cost with value of " + findMinimumCost);
        System.out.println("Therefore, the amount of possible non-minimum spanning trees is : " + totalSpanningTree);
        System.out.println("and from all of the non spanning trees, the lowest cost is  : " + findMinimumCost);
    }

    








    public boolean isConnect(int i, int j, int k, int temp[]) {
        for(; k < V; k++) {
            if(k == temp[i]) {
                connect = true; continue;
            }
            else if(k == i || k == j) {
                connect = true; continue;
            }
            connect = false;
        }
        return connect;
    }
}