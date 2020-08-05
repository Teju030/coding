import java.util.*;

public class _231A
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tot = 0;
        while( n-- > 0)
        {
            
            int res = 0;
            for(int i =0; i<3 ;i++)
                res+= sc.nextInt();
            if(res >=2)
                tot++;
        }
        System.out.println(tot);
    }
}