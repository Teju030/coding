//  Check if there is cycle in a directed graph

import java.util.*;
class CyclicDirected
{
    // inner class :  directed graph
    class Graph
    {
        int V;
        ArrayList<ArrayList<Integer>> adjList;
        Graph(int v)
        {
            V = v;
            adjList = new ArrayList<ArrayList<Integer>>();
            for(int i=0; i<V; i++)
            {
                adjList.add(new ArrayList<Integer>());
            }
        }
        void addEdge(int u, int v)
        {
            adjList.get(u).add(v);
        }
        void printadjlist()
        {
            System.out.println("\nAdjacency list of given inner class graph : ");
            for(int i = 0; i<adjList.size(); i++)
            {
                System.out.print(i);
                for(int j : adjList.get(i))
                {
                    System.out.print("-> "+j);
                }
                System.out.println();
            }
        }
        boolean isCyclicUtil(int s, boolean []visited, boolean []recStack)
        {   
            visited[s] = true;
            recStack[s] = true;
            for(int u : adjList.get(s))
            {
                if(!visited[u] && isCyclicUtil(u, visited, recStack))
                {
                    return true;
                }
                else
                {
                    if(recStack[u])
                        return true;
                }
            }
            recStack[s] = false;
            return false;
        }
        boolean isCyclic()
        {
            boolean visited[] = new boolean[V];
            boolean recStack[] = new boolean[V];
            for(int i=0; i<V; i++)
            {
                if(!visited[i] && isCyclicUtil(i, visited, recStack))
                {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String []args)
    {
        CyclicDirected cdg = new CyclicDirected();
        CyclicDirected.Graph g = cdg.new Graph(7);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,2);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(5,3);
        g.printadjlist();
        System.out.println("\nCheck if graph is cyclic or not : "+ g.isCyclic());
    }
}