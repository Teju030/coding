import java.util.*;
import java.io.*;
class PerCapita
{
    int V;
    ArrayList<Integer> adjList[];
    Set<Integer> currset = new HashSet<>();
    Set<Integer> maxset = new HashSet<>();
    PerCapita(int v)
    {
        V = v;
        adjList = new ArrayList[V];
        for(int i = 0; i<V; i++)
        {
            adjList[i] = new ArrayList<Integer>();
        }
    }
    void addEdge(int u, int v )
    {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    void DFSutil(int u, boolean []visited)
    {
        visited[u] = true;
        currset.add(u);
        for(int v: adjList[u])
        {
            if(!visited[v]) DFSutil(v, visited);
        }
    }

    void connectedCities()
    {
        boolean []visited = new boolean[V];
        for(int u = 0; u < V; u++)
        {
            if(!visited[u])
            {
                currset = new HashSet<>();
                DFSutil(u, visited);
                if(currset.size() > maxset.size())
                {
                    maxset = currset;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException
    {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int t = Integer.parseInt(in);

        while(t-- > 0)
        {
            String []input = br.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            long[] income = new long[n];
            long[] population = new long[n];
            double[] percapita = new double[n];
            // input income
            String []in_array = br.readLine().split("\\s+");
            for(int i =0; i<n ; i++)
            {
                income[i] = Long.parseLong(in_array[i]);
                percapita[i] = income[i];
            }
            // input popolation and calculate percapita income
            double maxpercapita = 0;
            in_array = br.readLine().split("\\s+");
            for(int i=0; i<n; i++)
            {
                population[i] = Long.parseLong(in_array[i]);
                percapita[i] = percapita[i]/population[i];
                maxpercapita = Math.max(maxpercapita, percapita[i]);
            }
            
            // get cities with max max percapita income
            Set<Integer> maxcities = new HashSet<Integer>();
            for(int i = 0; i<n; i++)
            {
                if(percapita[i] == maxpercapita)
                {
                    maxcities.add(i);
                }
            }
            PerCapita pc = new PerCapita(n);
            for(int i=0; i<m; i++)
            {
                String[] edges = br.readLine().split("\\s+");   
                int u = Integer.parseInt(edges[0])-1;
                int v = Integer.parseInt(edges[1])-1;
                if(maxcities.contains(u) && maxcities.contains(v))
                {
                    pc.addEdge(u,v);
                }
            }
            pc.connectedCities();
            // output
            System.out.println(pc.maxset.size());
            if(pc.maxset.size()>1)
            {
                for(int u: pc.maxset)
                    System.out.print(u+1 + " ");
            }
            else
            {
                for(int v : pc.maxset)
                    System.out.print(v+1);
            }
        }
    }
}
