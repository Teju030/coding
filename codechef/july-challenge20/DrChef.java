import java.util.*;

class DrChef
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            long x = sc.nextLong();
            PriorityQueue<Long> population = new PriorityQueue<Long>();
            while(n-- > 0)
            {
                population.add(sc.nextLong());
            }
            int days = 0;
            while(!population.isEmpty())
            {
                if(x < population.peek())
                {
                    x = x*2;
                    days++;
                }
                else if( x>= population.peek() && x <= population.peek()*2)
                {
                    long top = population.poll();
                    x = top*2;
                    days++;
                }
                else if( x> population.peek()*2)
                {
                    population.poll();
                    days++;
                }
            }

            System.out.println(days);
        }
    }
}