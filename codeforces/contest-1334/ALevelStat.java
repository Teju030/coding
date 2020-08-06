import java.util.*;

public class ALevelStat
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int p[] = new int[n+1];
            int c[] = new int[n+1];
            
            for(int i =1; i<=n; i++)
            {
                p[i] = sc.nextInt();
                c[i] = sc.nextInt();
            }

            boolean flag = true;

            for(int i = 1 ; i<=n; i++)
            {
                if(p[i-1] > p[i] || c[i-1] > c[i] || (p[i] - p[i-1]) < (c[i] - c[i-1]))
                {
                    flag = false;
                    break;
                } 
            }
            System.out.println(flag ? "YES" : "NO");

        }
    }
}