import java.util.*;

class BOLT {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0)
        {
            float k1 = sc.nextFloat();
            float k2 = sc.nextFloat();
            float k3 = sc.nextFloat();
            float v = sc.nextFloat();

            float res = k1*k2*k3*v ;
            //System.out.println("\nres"+res);
            res = 100f/res;
            double s =  Math.round(res*100.0)/100.0;
            //System.out.println(s);
            if(s < 9.58 )
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
    }
}
