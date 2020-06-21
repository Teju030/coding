import java.util.*;
class CacheHits
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int b = sc.nextInt();
            int m = sc.nextInt();
            int curBlock = -1;
            int swaps = 0;
            for(int i =0; i<m ; i++)
            {
                int e = sc.nextInt();
                int block = (int)Math.ceil(e/b);
                if(curBlock != block)
                {
                    curBlock = block;
                    swaps++;
                }
            }
            System.out.println(swaps);
        }
    }
}