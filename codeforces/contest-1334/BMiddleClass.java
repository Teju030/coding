import java.util.*;

public class BMiddleClass
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String []args)
    {
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            solver();
        }
    }
    public static void solver()
    {
        int n = sc.nextInt();
        long c = sc.nextLong();

        Long savings[] = new Long[n];
        for(int i =0; i<n; i++)
        {
            savings[i] = sc.nextLong() -c ;
        }

        long tot = 0;
        Arrays.sort(savings, Collections.reverseOrder());
        //System.out.println(Arrays.toString(savings));
        int i = 0;
        for( ;i < n; i++)
        {
            tot+= savings[i];
            if(tot < 0)
                break;
        }
        System.out.println(i);
    }
}