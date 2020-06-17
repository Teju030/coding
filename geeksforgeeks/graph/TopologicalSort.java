//Kahn's algorithm
import java.util.*;
class TopologicalSort
{
    class Graph
    {
        int V;
        ArrayList<ArrayList<Integer>> adjList;

        Graph(int v)
        {
            V = v;
            adjList = new ArrayList<ArrayList<Integer>>();
            for(int i=0; i<V; i++)
                adjList.add(new ArrayList<Integer>());
        }
        void addEdge(int u, int v)
        {
            adjList.get(u).add(v);
        }
        int[] getIndegree()
        {
            int []indegree = new int[V];
            for(int i =0; i<V; i++)
            {
                for(int u : adjList.get(i))
                    indegree[u]++;
            }

            return indegree;
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
        void printTopologicalSort()
        {   
            Queue<Integer> q = new LinkedList();
            int indegree[] = getIndegree();
            // add 0 indegree nodes in the queue
            for(int i=0; i<indegree.length; i++)
            {
                if(indegree[i] == 0)    q.add(i);
            }
            while(!q.isEmpty())
            {
                int curr = q.poll();
                System.out.print(curr + " " );
                for(int u : adjList.get(curr))
                {
                    indegree[u]--;
                    if(indegree[u] == 0)
                        q.add(u);
                }
            }
        }

        // topological sort using DFS traversal 
        void topologicalSortDFS()
        {
            boolean visited[] = new boolean[V];
            Stack<Integer> stk = new Stack();
            // run DFS traversal on graph
            for(int i=0; i<V; i++)
            {
                if(!visited[i]) 
                    DFSUtil(i, visited, stk);
            }
            // print the stack
            while(!stk.isEmpty())
            {
                System.out.print(stk.pop() + " ");
            }
        }
        void DFSUtil(int s, boolean[] visited ,Stack<Integer> stk)
        {
            visited[s] = true;
            for(int u : adjList.get(s))
            {
                if(!visited[u])
                {
                    DFSUtil(u, visited, stk);
                }
            }
            // Once all its neighbours are processed then push onto stack
            stk.push(s);
        }
    }
    public static void main(String []args)
    {
        TopologicalSort tp = new TopologicalSort();
        TopologicalSort.Graph g = tp.new Graph(6);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        System.out.println("\nTopological sort of graph");
        g.printTopologicalSort();
        System.out.println("\nTopological sort using DFS traversal ");
        g.topologicalSortDFS();
    }
}