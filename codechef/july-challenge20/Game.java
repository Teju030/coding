import java.util.*;

class Game
{
    public static long digitSum(String a)
    {
        int sum =0 ;
        for(int i =0; i<a.length(); i++)
        {   
            sum += Character.getNumericValue(a.charAt(i));
        }
        return sum;
    }
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int []score = new int[2];
            while(n-- > 0)
            {
                long a = digitSum(sc.next());
                long b = digitSum(sc.next());
                if(a-b == 0)
                {
                    score[0]++;
                    score[1]++;
                }
                else if(a>b)
                {
                    score[0]++;
                }
                else
                    score[1]++;
            }
            if(score[0] == score[1])
            {
                System.out.println("2 "+score[0]);
            }
            else if(score[0]> score[1])
                System.out.println("0 "+score[0]);
            else
                System.out.println("1 "+score[1]);
        }
    }
}
