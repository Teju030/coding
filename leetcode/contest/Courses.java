import java.util.*;
class Solution {
    int V;
    ArrayList<Integer> adjList[];
    int []indegree;
    public void initGraph(int v, int edges[][])
    {
        V = v;
        adjList = new ArrayList[V];
        indegree = new int[V];
        for(int i=0; i<v; i++)
        {
            adjList[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<edges.length; i++)
        {
            addEdge(edges[i][0] -1, edges[i][1] -1);
        }
    }
    public void addEdge(int u, int v)
    {
        adjList[u].add(v);
        indegree[v]++;
    }

    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        initGraph(n, dependencies);
        //printAdjlist();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<V; i++)
        {
            if(indegree[i] == 0)
                queue.add(i);
        }
        int semesters = 0;
        int courses = 0;
        while(!queue.isEmpty())
        {
            int qsize = queue.size();
            semesters +=(int)Math.ceil((double)qsize/k);
            for(int i=0; i<qsize; i++)
            {
                int curr = queue.poll();
                for(int u: adjList[curr])
                {
                    indegree[u]--;
                    if(indegree[u]==0)
                        queue.add(u);
                }
            }
        }
        return semesters;
    }
    void printAdjlist()
    {
        System.out.println("Indegree");
        System.out.println(Arrays.toString(indegree));
        System.out.println("\nAdjacency list of given graph : ");
        for(int i = 0; i<adjList.length; i++)
	    {
	        System.out.print(i);
	        for(int j : adjList[i])
	        {
	            System.out.print("-> "+j);
	        }
	        System.out.println();
	    }
    }
}

public class Courses
{
    
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int n = 11;
        int [][]dep= {
            // n = 4, dependencies = [[2,1],[3,1],[1,4]], k = 2
            //n = 5, dependencies = [[2,1],[3,1],[4,1],[1,5]], k = 2
            //{2, 1},{3,1},{1,4}
            //{2,1},{3,1},{4,1},{1,5}
            // n = 8 d = [[1,6], [3,4], [2,7], [2,5], [8,7]] k=3
            
        };
        int k = 3;
        System.out.println(s.minNumberOfSemesters(n, dep, k));
    }
}