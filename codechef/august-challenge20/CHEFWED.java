import java.util.*;

class CHEFWED
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int f[] = new int[n];
            for(int i = 0; i< n ; i++)
            {
                f[i] = sc.nextInt();
            }
            solver_old( n , k ,f);
        }
    }

    public static void solver_old(int n, int k , int []f)
    {
        int tables = 1;
        int fights = 0;
        int i = 0;
        HashSet<Integer> guests = new HashSet<Integer>(); 
        HashSet<Integer> conflict = new HashSet<Integer>();
        while(i<n)
        {
            if(guests.contains(f[i]))
            {
                long cost_t = (tables+1)*k + fights;
                long cost_f = tables*k + fights+1;
                if(cost_t > cost_f)
                {
                    // increase fights
                    if(conflict.contains(f[i])) 
                        fights++;
                    else
                    {
                        fights = fights+2;
                        conflict.add(f[i]);
                    }
                }
                else
                {
                    // increase tables
                    tables++;
                    conflict = new HashSet<Integer>();
                    guests = new HashSet<Integer>();
                    guests.add(f[i]);
                }
            }
            else{
                guests.add(f[i]);
            }

            // System.out.println(" i "+ i  + " tables " + tables + " fights : "+ fights + " guests "+ guests);
            
            i++;
        }

        long cost = tables*k + fights;
        System.out.println(cost);
    }
}

/*
1
5 20 
10 10 10 1 1

1
7 2
10 10 10 1 1 6 6
*/