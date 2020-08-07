import java.util.*;

public class Infection
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int inf[] = new int[m];
        for(int i = 0; i<m ;i++)
            inf[i] = sc.nextInt();
        System.out.println("ans: "+ solver(n, m , inf));
    }
    static long solver(int n, int m , int []inf)
    {
       // System.out.println("solver");
        TreeMap<Integer, Integer> map = new TreeMap();
        int j = 1;
        for(int i = 1; i<=n ;i++)
        {
            if(i < inf[j] && i!=inf[j] && i!= inf[j-1])
            {
                int min_i = Math.abs(i - inf[j-1]);
                min_i = Math.min( min_i, Math.abs( i - inf[j]));
                if(map.containsKey(min_i))
                {
                    map.put(min_i, map.get(min_i)+1);
                }
                else
                {
                    map.put(min_i, 1);
                }
            }
            else
            {
                if(j+1 < m)
                    j++;
            }
        }
        // for (Map.Entry<Integer,Integer> entry : map.entrySet())  
        //     System.out.println("Key = " + entry.getKey() + 
        //                      ", Value = " + entry.getValue()); 
        long ans = 1;
        long last_val = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet())
        {   
            last_val += e.getValue();
            ans *=last_val;
            ans %= 1000000007;
            last_val = (last_val-1 == 0) ? 1: last_val-1;
        }
        // factorial of remaining
        while(last_val>0)
        {
            ans *=last_val;
            ans %= 1000000007;
            last_val--;
        }
        return ans;
    }

}