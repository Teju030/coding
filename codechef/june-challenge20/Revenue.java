import java.util.*;
class Revenue
{
    static int getLoss(int []in, int cut)
    {
        int total = 0;
        int aftercut = 0;
        for(int i : in)
        {
            total+= i;
            if(i > cut)
            {
                aftercut+= cut;
            }
            else
                aftercut+=i;

        }
        return total - aftercut;
    }
    public static void main(String []args)
    {
        Scanner sc = new Scanner( System.in);
        int n = sc.nextInt();
        while(n>0)
        {
            int len = sc.nextInt();
            int cut = sc.nextInt();
            int []in = new int[len];
            for(int i =0; i<len; i++)
            {
                in[i] = sc.nextInt();
            }
            // System.out.println("\nInput array");
            // for(int i : in)
            //     System.out.print(i + " ");
            // System.out.println();
            System.out.println(getLoss(in, cut));
            n--;
        }
    }
}