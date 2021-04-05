import java.util.*;
import java.util.HashMap;

class SDICE{
    public static void main (String []args)
    {
        Scanner sc = new Scanner(System.in);
        //                    0   1   2  3    4  5   6   7   8
        int pre[] = new int[]{0, 20, 36, 51, 60, 76, 88, 99, 104};
        int t = sc.nextInt();
        while(t-- > 0)
        {
            long n = sc.nextLong();
            if(n<9)
                System.out.println(pre[(int)n]);
            else{
                long rem = n % 4;
                long d = n / 4;
                long res = d * 44 + 4 * ( 4 - rem) + pre[(int)rem];
                System.out.println(res);
            }
        }
    }
}