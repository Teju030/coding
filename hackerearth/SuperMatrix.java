import java.util.*;

class SuperMatrix
{
    public static int solve(int N, int X, int Y, int Z, int T, int[] A)
    {
        int res  = 0;
        int xr[] = new int[N];
        
        for(int i=X-1; i<Z; i++ )
        {
            for(int j=Y-1; j<T; j++)
            {
                if(i == (X-1) && j==(Y-1))
                    res = (A[i]&A[j]);
                else
                    res ^= (A[i]&A[j]);
            }
        }
        return res;
    }
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int t = sc.nextInt();

        int []a = new int[n];
        for(int i =0 ;i<n; i++)
        {
            a[i] = sc.nextInt();
        }
        System.out.println(solve(n, x, y, z ,t, a));
    }
}

/*
3 1 2 2 3
1 2 3
*/

// while(ri>=0 || gi>=0 || bi>= 0)
// {
//     if(R)  // letter R
//     {
//         while(ri>=0 && r[ri]==0) ri--;
//         if(ri>=0)
//         {
//             res+=ri;
//             r[ri]--;
//         }
//     }
//     else if() // G
//     {
//         while(ri>=0 && r[ri]==0) ri--;
//         if(ri>=0)
//         {
//             res+=ri;

//         }
//     }

// }