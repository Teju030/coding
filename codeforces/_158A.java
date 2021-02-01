import java.util.*;

public class _158A
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt()-1;
        int k = sc.nextInt()-1;
        sc.nextLine();
        int res = 0;
        int i = 0;
        int kth = 0;
        while(i<=n)
        {
            int num = sc.nextInt();
            //System.out.println("\n num : "+num);
            if(num<=0)
                break;
            else if( i == k)
            {
                kth = num;
            }
            if (i>k && num != kth)
                break;
            res++;
            i++;
        }
        System.out.println(res);
    }
}