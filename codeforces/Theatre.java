import java.util.*;

public class Theatre
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        double m = sc.nextDouble();
        double n = sc.nextDouble();
        double a = sc.nextDouble();
        //System.out.println(Math.ceil((double)m/a));
        System.out.println((long)(Math.ceil(m/a)*Math.ceil(n/a)));

    }
}

//1000000000 1000000000 1
// 1000000000000000000