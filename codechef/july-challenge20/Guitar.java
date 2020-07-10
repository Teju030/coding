import java.util.*;

class Guitar
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0)
        {
            int n = sc.nextInt();
            long skip = 0;
            long f = sc.nextLong();
            n--;
            
            while(n-- > 0)
            {
                long s = sc.nextLong();
                skip += Math.abs(s-f) -1;
                //System.out.println("Skip " + skip);
                f = s;
            }
            System.out.println(skip);
        }
    }
}