import java.util.*;
class Graph
{
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v)
    {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    static void printAdjlist(ArrayList<ArrayList<Integer>> list)
    {
        for(int i = 0; i<list.size(); i++)
	    {
	        System.out.print(i);
	        for(int j : list.get(i))
	        {
	            System.out.print("-> "+j);
	        }
	        System.out.println();
	    }
    }
    static void BFShelper(ArrayList<ArrayList<Integer>> adjList, int S, boolean[] visited)
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
    static void BFS(ArrayList<ArrayList<Integer>> adjList, int V)
    {
        System.out.println("\n BFS traversal of Graph");
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++)
        {
            //System.out.println("\n vertex : " + i);
            if(!visited[i])
                BFShelper(adjList, i, visited);
        }
    }

    static void DFShelper(ArrayList<ArrayList<Integer>> adjList, int S, boolean[] visited)
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

    static void DFS(ArrayList<ArrayList<Integer>> adjList, int V)
    {
        System.out.println("\n DFS traversal of graph");
        boolean []visited = new boolean[V];
        for(int i =0; i< V; i++)
        {
            if(!visited[i])
            {
                DFShelper(adjList, i, visited);
            }
        }
    }
    public static void main(String []args)
    {
        int V = 7;
        ArrayList<ArrayList <Integer>> adjList = new ArrayList<ArrayList<Integer>>(V);
        for(int i =0; i<V; i++)
            adjList.add(new ArrayList<Integer>());
        addEdge(adjList, 0,4);
        addEdge(adjList, 1,2);
        addEdge(adjList, 1,3);
        addEdge(adjList, 1,4);
        addEdge(adjList, 3,4);
        printAdjlist(adjList);
        BFS(adjList, V);
        DFS(adjList, V);
    }
}