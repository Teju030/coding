import java.util.*;

class SPAMCLASS
{
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int minX = sc.nextInt();
            int maxX = sc.nextInt();

            int w[] = new int[n];
            int b[] = new int[n];
            for(int i=0; i<n; i++)
            {
                w[i] = sc.nextInt();

                b[i] = sc.nextInt();

            }
            int even = 0;
            int odd = 0;
            int res[] = {0,1};
            for(int i=0; i<n ;i++)
            {
                // y = x*w + b
                res[0] = res[0]*w[i]+b[i];
                res[1] = res[1]*w[i]+b[i];
                res[0] %=2;   
                res[1] %=2;   
            }

            if(res[minX%2]==0)
            {
                even += (maxX - minX)/2 +1;
            }
            if(res[(minX+1)%2]==0)
            {
                even +=(maxX-minX-1)/2 +1;
            }

            odd = maxX - minX + 1 - even;

            System.out.println(even+" " +odd);
        }
    }
}