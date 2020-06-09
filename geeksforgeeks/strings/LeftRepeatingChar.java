// Given a string find the leftmost repeating character
import java.util.*;
class LeftRepeatingChar
{
    static int naiveSolution(String s)
    {   

        for( int i = 0 ; i<s.length(); i++)
        {
            int temp = i;
            for( int j = i+1; j< s.length(); j++)
            {
                if( s.charAt(i) == s.charAt(j))
                {
                    temp = j;
                    break;
                }
            }
            if( temp!= i)
            {
                return i;
            }
        }
        return -1;
        
    }
    static int optimumSolution(String s)
    {
        int count[] = new int[256];
        Arrays.fill(count, -1);
        int res = Integer.MAX_VALUE;
        for(int i=0; i< s.length(); i++)
        {
            if(count[s.charAt(i)] == -1)
            {
                count[s.charAt(i)] = i;
            }
            else
            {
                res = Math.min(res, count[s.charAt(i)]);
            }
        }
        if( res == Integer.MAX_VALUE) return -1;
        return res;
    }
    public static void main(String []args)
    {
        String s = "geeksforgeeks";
        System.out.println("Naive solution output: "+ LeftRepeatingChar.naiveSolution(s));
        System.out.println("Optimized solution output: "+ LeftRepeatingChar.optimumSolution(s));
    }
}