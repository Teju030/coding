import java.util.*;

class CRDGAME3
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int c = sc.nextInt();
            int r = sc.nextInt();
            int dc = (c/9) + (c%9 !=0 ? 1:0);
            int dr = (r/9) + (r%9 !=0 ? 1:0);
            if(dc < dr)
            {
                //chef
                System.out.println(0 + " "+ dc);
            }
            else
            {
                // rick
                System.out.println(1 + " "+ dr);
            }
        }
    }
}