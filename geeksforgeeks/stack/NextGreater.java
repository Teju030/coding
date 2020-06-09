// Find the just greater element on the right side of the current element in given array
import java.util.*;
class NextGreater
{
    static void nextGreaterElement(int []a)
    {
        Stack<Integer> stk = new Stack<>();
        int []res = new int[a.length];
        
        for(int i = a.length-1; i>=0; i--)
        {
            while(!stk.isEmpty() && stk.peek()<=a[i])
            {
                stk.pop();
            }
            if(stk.isEmpty())
                res[i] = -1;
            else
                res[i] = stk.peek();
            stk.push(a[i]);
        }

        for(int i=0; i< res.length; i++)
        {
            System.out.print(res[i]+"   ");
        }
    }
    public static void main(String []args)
    {
        int a[] = { 20, 30, 10, 5, 15};
        nextGreaterElement(a);
    }
}