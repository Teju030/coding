// To find out previous just greater than the current element  in an array 
import java.util.*;
class PreviousGreater
{
    static void prevGreater(int []a)
    {
        Stack<Integer> stk = new Stack<>();
        
        for(int i=0; i<a.length; i++)
        {
            while(!stk.isEmpty() && stk.peek()<=a[i])
            {
                stk.pop();
            }
            if(stk.isEmpty())
            {
                System.out.print("-1"+" ");
            }
            else
            {
                System.out.print(stk.peek() + " ");
            }
            stk.push(a[i]);
        }
    }
    public static void main(String []args)
    {
        int a[] = { 20, 30, 10, 5, 15};
        prevGreater(a);
    }
}