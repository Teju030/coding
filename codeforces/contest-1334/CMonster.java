import java.util.*;

public class CMonster
{
   static long h[] = new long[300003];
   static long b[] = new long[300003];
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t-- > 0)
        {
            int n = sc.nextInt();

            for(int i =0; i<n ; i++)
            {
                h[i] = sc.nextLong();
                b[i] = sc.nextLong();
            }

            long total = 0;
            
            
            for(int i =0; i<n ;i++)
            {
                int j = (n+i-1)%n;
                //System.out.println("j " +j);
                if(h[i]>b[j])
                {
                    total += (h[i] - b[j]);
                    h[i] = b[j];
                }
                    
                
            }
            long min = h[0];
            //System.out.println(Arrays.toString(h));
            //System.out.println(Arrays.toString(b));
            for(int i =1; i<n ;i++)
            {
                min = Math.min(min, h[i]);
            }
            System.out.println(min+total);
        }
    }
}