// to find out all the paths from s to t

import java.util.*;

public class AllPaths
{
    public void printAllPaths(int s, int t)
    {

    }
    public void printAllPathsUtil(int u, int v, boolean)
    public static void main(String []args)
    {

    }
}

class Graph
{
    int V;
    ArrayList<Integer> adjList;
    Graph(int V)
    {   
        this.V = V;
        adjList = new ArrayList<Integer>(V);
        for(int i =0 ; i<V ; i++)
        {
            adjList[i] = new ArrayList<Integer>();
        }
    }

    void addEdge(int u, int v )
    {
        adjList[u].add(v);
    }
}