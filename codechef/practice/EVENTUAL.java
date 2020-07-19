import java.util.*;

class EVENTUAL
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt(); sc.nextLine();
            int []alpha = new int[26];
            char []in = sc.nextLine().toCharArray();
            
            // System.out.println("\ninput : "+ Arrays.toString(in));
            for(char c : in)
            {
                alpha[c-97]++;
            }
            // System.out.println("\n alpha : "+ Arrays.toString(alpha));
            boolean flag = true;
            for(int i : alpha)
            {
                if(i%2 !=0)
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}