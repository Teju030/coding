import java.util.*;
class Graph
{
    int V;
    ArrayList<ArrayList <Integer>> adjList;
    Graph(int V)
    {
        this.V = V;
        adjList = new ArrayList<ArrayList<Integer>>(V);
        for(int i =0; i<V; i++)
            adjList.add(new ArrayList<Integer>());
    }
    void addEdge(int u, int v)
    {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    void printAdjlist()
    {
        System.out.println("\nAdjacency list of given graph : ");
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
    void BFShelper( int S, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList();
        q.add(S);
        visited[S] = true;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            System.out.print(curr + " ");
            for(int i : adjList.get(curr))
            {
                if(!visited[i])
                {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
    void BFS()
    {
        System.out.println("\nBFS traversal of Graph");
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(!visited[i])
                BFShelper( i, visited);
        }
    }

    void DFShelper(int S, boolean[] visited)
    {
        Stack<Integer> stk = new Stack();
        stk.push(S);
        visited[S] = true;
        while(!stk.isEmpty())
        {
            int curr = stk.pop();
            System.out.print(curr + " ");
            for(int i : adjList.get(curr))
            {
                if(!visited[i])
                {
                    visited[i] = true;
                    stk.push(i);
                }
            }
        }

    }

    void DFS()
    {
        System.out.println("\nDFS traversal of graph");
        boolean []visited = new boolean[V];
        for(int i =0; i< V; i++)
        {
            if(!visited[i])
            {
                DFShelper( i, visited);
            }
        }
    }

    public static void main(String []args)
    {
        Graph g  = new Graph(5);
        g.addEdge(0,4);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(3,4);
        g.printAdjlist();
        g.BFS();
        g.DFS();
    }
}