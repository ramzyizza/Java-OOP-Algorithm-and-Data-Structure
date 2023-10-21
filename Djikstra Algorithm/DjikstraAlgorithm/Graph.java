package DjikstraAlgorithm;

public class Graph {
    int totalNode;
    int[][] adjacencyMatrix;
    
    //constructor to initialize size of 2d array
    public Graph(int vertex){
        totalNode = vertex;
        adjacencyMatrix = new int[vertex][vertex]; //n x n size
    }
    //add path method
    public void addEdge(int from, int to, int weight){
        //declare from and to as it is a undirected graph but weighted graph
        adjacencyMatrix[from][to] = weight; //declare size of weight
        adjacencyMatrix[to][from] = weight; 
    }
    //print Adjacency Matrix 2D array that correspond to the graph
    public void printGraph(){
        for(int i = 0; i < totalNode; i++){
            for(int j = 0; j < totalNode; j++){
                System.out.printf("%5d", adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
    }
 
    //dijkstra algorithm method
    public void dijkstra(int start, int end){
        //int array to store the distance
        int[] distance = new int[totalNode];
        //boolean array to store if node no longer used
        boolean[] fixed = new boolean[totalNode];
        //int length to compute the length from index 0 
        int totalNode = adjacencyMatrix[0].length;
        //int array containing the range of shortest path of tree from parent
        int[] range = new int [totalNode];
        //int array containing the parent
        int[] nodeParent = new int[totalNode];
        nodeParent[start] = -1; //since parent of starting value doesn't exist
        //put the final computed vertex to this boolean array
        boolean[] computed = new boolean[totalNode];

        //set all the distance except the starting value as infinite
        for(int i = 0; i < totalNode; i++){
            distance[i] = Integer.MAX_VALUE; //computing distance
            range[i] = Integer.MAX_VALUE;    //find the path
            fixed[i] = false;                //computing distance
            computed[i] = false;             //find the path
        }
        
        //distance of starting value set to 0
        distance[start] = 0;
        range[start] = 0;

        //compute the shortest distance loop
        while(true){
            //find the minimum index that we will visit
            int visit = minIndex(distance, fixed);
            //break if index < 0
            if(visit < 0) 
                break;
            //break if distance is infinite
            if(distance[visit] == Integer.MAX_VALUE) 
                break;
            //set the visited node to fixed node / true
            fixed[visit] = true;
            for(int j = 0; j < totalNode; j++){
                if(adjacencyMatrix[visit][j] > 0 && !fixed[j]){
                    //compute the new total distance with smaller value
                    int newDistance = distance[visit] + adjacencyMatrix[visit][j];
                    //if new distance < previous distance, update the value
                    if(newDistance < distance[j])
                        distance[j] = newDistance;
                }
            }
        }
        //evaluate if distance of destination is infinite
        //hence there are no such route to that node
        if(distance[end] == Integer.MAX_VALUE)
            System.out.println("\nNo Route");
        //else there exist a path with n distance
        else{
            System.out.println("\nDistance from Vertex-a to Vertex-i =  " + distance[end] + "\n\n");
        }   
        
        //find the shortest path algorithm
		for (int i = 1; i < totalNode; i++){
            //set the first previsit to -1, since there's no such parent on starting vertex
			int previsit = -1;
            //nearest vertex at initialization will be infinite
			int nearest = Integer.MAX_VALUE;
            //loop to find the shortest path by comparing the distance of nearest node
            //and the current range stored in range[j]
			for (int j = 0; j < totalNode; j++){
                //if not vertex not yet set as fixed/final, and range is closer
                //then update the value of previsit & nearest value
				if (nearest > range[j] && !computed[j] ){
					nearest = range[j];
                    previsit = j;
				}
			}
            //insert to boolean array for vertex that have final value
			computed[previsit] = true;

            //iterate till final node to find the shortest path
			for (int j = 0; j < totalNode; j++){
				int edgeLength = adjacencyMatrix[previsit][j];
				//if new range is smaller then previous range, update the value
				if ((range[j] > (nearest + edgeLength)) && edgeLength > 0) {
                    //set node parent to previsit
                    nodeParent[j] = previsit;
                    //update new range with the closer one
					range[j] = nearest + edgeLength;
				}
			}
		}
        //recall the findpath method
        findPath(start, range, nodeParent);  
    }

    //compute the minimum index that will be visited next
    public int minIndex(int[] distance, boolean[] fixed){
        //starts to compute from first node
        int index = 0;
        //iterate to check if we will visit fixed node or not
        for(; index<fixed.length ; index++)
            if(!fixed[index])
                break; //if not fixed yet, we proceed to next if statement
                //but if node is fixed, we continue to loop
        //if we stop at the the last index, which == total length index
        //stop the loop
        if(index == fixed.length)
            return -1;
        //iterate to check if node that we visit haven't fixed yet
        //and the distance if smaller than previous determined distance
        //then, its the node that we will visit
        for(int i = index + 1; i < fixed.length; i++)
            if(!fixed[i] && distance[i] < distance[index])
                index = i;
        //after computing, we return the minimum index to visit it after
        return index;
    }

    //algorithm to find the shortest path
	public void findPath(int start, int[] distance, int[] nodeParent){
        //iterate to each node/vertex
        for (int i = 0; i < distance.length; i++) {
			if (i != start){
                //+65 to convert to ascii char
                System.out.print("Distance from A" + " to " + (char)(i+65));
				System.out.print(" is : " + distance[i]); //output the array containing distance
                System.out.print("\nTraversing along the path: ");
                //invoke the display path method 
				displayPath(i, nodeParent);
                System.out.println();
			}
            System.out.println();
		}
	}

    //method to display the shortest path
    public void displayPath(int currentVertex, int[] nodeParent) {
        //basecase
        if (currentVertex == -1)
            return;
        //recursion process
        displayPath(nodeParent[currentVertex], nodeParent);

        //convert int to ascii character
        int convert = currentVertex+65;
        char alphabet = (char)convert;
        //output the shortest path 
        System.out.print(alphabet + " ");
    }
}