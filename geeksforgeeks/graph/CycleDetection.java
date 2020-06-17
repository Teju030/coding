// Cycle detection in undirected graph 
import java.util.*;
class CycleDetection
{
    static boolean DFShelper(ArrayList<ArrayList<Integer>> adjList, boolean visited[], int s, int parent )
    {
        visited[s] = true; 
        for(int u : adjList.get(s))
        {
            if(!visited[u])
            {    
                if(DFShelper(adjList, visited, u, s))   
                    return true;
            }
            else
            {   
                if(u != parent)
                    return true;
            }
        }
        return false;
    }
    static boolean isCycle(ArrayList<ArrayList<Integer>> adjList, int V)
    {
        boolean visited[] = new boolean[V];
        for(int i = 0; i<V; i++)
        {
            if(!visited[i])
            {
                if(DFShelper(adjList, visited, i, -1))
                    return true;
            }

        }
        return false;
    }
    public static void main(String []args)
    {
        
        Graph g = new Graph(7);
        g.addEdge(0,3);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        //g.addEdge(3,4);
        //g.addEdge(0,4);
        g.printAdjlist();
        System.out.println("\nCheck if cycle present in the graph or not : " + isCycle(g.adjList, g.V));
    }
}