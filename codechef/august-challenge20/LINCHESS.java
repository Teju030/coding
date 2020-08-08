import java.util.*;

class LINCHESS
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Integer []p = new Integer[n];
            for(int i =0 ; i<n; i++)
            {
                p[i]= sc.nextInt();
            }
            Arrays.sort(p);
            int res = -1;
            for(int i = n-1; i>=0; i--)
            {
                if(k % p[i] == 0 )
                {
                    res = p[i];
                    break;
                }
            }
            System.out.println(res);
        }

    }
}