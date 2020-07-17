import java.util.*;

class JAIN
{

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            sc.nextLine();
            HashSet<Character> []dishes = new HashSet[n];
            for(int i = 0 ; i<n ; i++)
            {
                dishes[i] = new HashSet<Character>();
                String dish = sc.nextLine();
                // System.out.println("input dish : "+ dish);
                for(int j = 0; j<dish.length(); j++)
                    dishes[i].add(dish.charAt(j));
            }
            
            int total = 0;
            // for(HashSet d : dishes)
            //     System.out.println(d);
            for(int i=0; i<n; i++)
            {
                for(int j=i+1; j<n; j++)
                {
                    HashSet<Character> meal = new HashSet<Character>();
                    meal.addAll(dishes[i]);
                    meal.addAll(dishes[j]);
                    // System.out.println("meal : "+ meal);
                    if(meal.size() == 5)
                        total++;
                }
            }
            System.out.println(total);
        }
    }
}