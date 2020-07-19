import java.util.*;

class Solution {
   
    ArrayList<Integer> []adjList;
    int []freq;
    public int[] solve(int u, int n, String l, boolean[] visited)
    {
        int []alpha = new int[26];
        if(u>=n)    return alpha;
        visited[u] = true;
        //System.out.println("\nVertex : "+ u+ " -> "+ Arrays.toString(alpha));
        for(int v : adjList[u])
        {
            if(!visited[v])
            {
                int []tmp = solve(v, n, l, visited);
                for(int i =0; i < 26 ; i++)
                {
                    alpha[i] +=tmp[i];
                }
            }
        }
        int val = l.charAt(u) - 97;
        alpha[val]++;
        freq[u] = alpha[val];
        return alpha;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
    
        int alpha[] = new int[26];
        freq = new int[n];
        adjList =  new ArrayList[n];
        for(int i = 0; i< n ;i++)
        {
            adjList[i] = new ArrayList();
        }
        
        for(int i =0; i<edges.length; i++)
        {
            adjList[edges[i][0]].add(edges[i][1]);  
            adjList[edges[i][1]].add(edges[i][0]);     
        }
        boolean []visited = new boolean[n];
        
        for(int i=0; i<n ; i++)
        {
            if(!visited[i])
                solve(0, n, labels, visited);
        }
        return freq;
    }
}

class TreeLabels
{
    public static void main(String []args)
    {
        int n = 4;
        int [][]edges = 
        {
            { 0, 1}, { 1, 2}, { 0, 3}
        };
        String l = "bbbb";
        Solution s = new Solution();
        int res[] = s.countSubTrees(n, edges, l);
        System.out.println("\nResult: "+ Arrays.toString(res));
    }
}
/*
7
[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]
 {0, 1}, { 0, 2},
            { 1, 4}, { 1, 5},
            { 2, 3}, { 2, 6}
"abaedcd"


n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb"
{ 0, 1}, { 1, 2}, { 0, 3}
 */