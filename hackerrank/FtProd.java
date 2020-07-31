import java.util.*;

class FtProd
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String []prod = new String[n];
        for(int i =0; i<n ;i++)
        {
            prod[i] = sc.next();
        }
        System.out.println(getFtProd(prod));
    }
    public static String getFtProd(String []products)
    {
        TreeMap<String, Integer> map = new TreeMap<>();
        for(String s: products)
        {
            if(map.containsKey(s))
            {
                map.put(s, map.get(s)+1);
            }
            else
            {
                map.put(s, 1);
            }
        }
        int max = 0;
        String res = "";
        for(Map.Entry<String, Integer> lastEntry: map.entrySet())
        {
                if(lastEntry.getValue()>= max)
                {
                    max = lastEntry.getValue();
                    res = lastEntry.getKey();
                }
        }
       
        System.out.println(lastEntry.getKey());
        return res;
    }
}

/*
Input : 

10
yellowShirt
redHat
blackShirt
bluePants
redHat
pinkHat
blackShirt
yellowShirt
greenPants
greenPants

output:
yellowShirt
*/