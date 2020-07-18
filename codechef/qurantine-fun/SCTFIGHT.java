import java.io.*;
import java.util.*;

class SCTFIGHT
{
    public static void main(String []args)
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- >0)
        {
            int n = s.nextInt();

            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
               int a = s.nextInt();
            if(map.containsKey(a))
				map.put(a, map.get(a)+1);
			else
				map.put(a, 1);
            }
            int max=0;
            for(int key : map.keySet())
            {
                max = Math.max(max,map.get(key));
            }
            System.out.println(max);
        } 
    }
}
