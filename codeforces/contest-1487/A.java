import java.util.*;

public class A
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int in[] = new int[n];
            for(int i = 0; i<n; i++)
            {
                in[i] = sc.nextInt();
            }
            Arrays.sort(in);
            int cnt = 0;
            for(int i = 1; i<n ; i++)
            {
                if(in[0] != in[i]){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}