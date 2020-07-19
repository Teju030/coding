import java.util.*;

class ORTHODOX
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt(); 
            long []in = new long[n];
            long max =0; 
            for(int i =0 ;i< n; i++)
            {    
                in[i] = sc.nextLong();
                max = Math.max(max, in[i]);
            }
            
            if(max%2==0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}