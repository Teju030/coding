import java.util.*;

class MissingPoint
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            n = 4*n-1;
            int m_x = 0;
            int m_y = 0;
            while(n-- >0)
            {
                m_x ^= sc.nextInt();
                m_y ^= sc.nextInt();
            }
            System.out.println(m_x + " "+m_y);
        }
    }
}