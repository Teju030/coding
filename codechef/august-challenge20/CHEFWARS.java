import java.util.*;

class CHEFWARS
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0)
        {
            int h = sc.nextInt();
            int p = sc.nextInt();
            int winner = 1;
            while(h > 0 && p> 0 )
            {
                h -=p;
                p = (int)Math.floor(p/2.0);
            }
            if(h > 0 )
                winner = 0;
            System.out.println(winner);
        }
    }
}