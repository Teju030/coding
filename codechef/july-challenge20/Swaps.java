import java.util.*;

class Swaps
{
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            long a[] = new long[n];
            long b[] = new long[n];
            for(int i=0; i<n; i++)
                a[i] = sc.nextLong();
            for(int i=0; i<n; i++)
                b[i] = sc.nextLong();
            
            Arrays.sort(a);
            Arrays.sort(b);

            long swaps = 0;
            for(int i = 0; i<n;)
            {
                if(a[i] == b[i])
                    i++;
                else
                {
                    if(i == n-1)
                    {
                        swaps = -1;
                        break;
                    }
                    else{
                        if(a[i]!=a[i+1] || b[i]!=b[i+1])
                        {
                            swaps = -1;
                            break;
                        }
                        swaps += Math.min(a[i], b[i]);
                        long tmp = a[i];
                        a[i] = b[i+1];
                        b[i+1] = tmp;
                        i +=2; 
                    }
                }
            }
            System.out.println(swaps);
        }
    }
}