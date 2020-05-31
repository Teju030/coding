// Find the left most non repeating character
import java.util.*;
class LeftNonrepeatingChar
{
    static int firstNonrepeatingChar(String s)
    {
        int res = Integer.MAX_VALUE;
        int f_index[] = new int[256];
        // initialise array to -1
        Arrays.fill(f_index, -1);
        // first occurance set i
        // second occurance reset to -2
        for( int i=0; i<s.length(); i++)
        {
            if( f_index[s.charAt(i)] ==-1 )  
                f_index[s.charAt(i)] = i;
            else
                f_index[s.charAt(i)] = -2;
        }
        //find the first non repeating
        for(int i=0; i<256; i++)
        {
            if(f_index[i] >=0) 
                res = Math.min(res, f_index[i]);
        }
        return (res == Integer.MAX_VALUE)? -1: res;
    }
    public static void main(String []args)
    {
        String s = "geeksforgeeks";
        LeftNonrepeatingChar ln = new LeftNonrepeatingChar();
        System.out.println(ln.firstNonrepeatingChar(s));
    }
}