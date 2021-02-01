import java.util.*;

public class _158B
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int []f = new int[4];
        for(int i =0 ; i<n ;i++)
        {
            int num = sc.nextInt();
            f[num-1]++;
        }

        int cars  = 0;
        cars += f[3];
        f[0] -= (f[2]>f[0]) ?  f[0] : f[2];
        cars += f[2];
        cars += f[1]/2;
        f[1] = f[1]%2;
        int last = (f[1]*2 + f[0]);
        cars += last/4;
        cars += (last % 4 > 0) ? 1 : 0;
        System.out.println(cars);
    }
}