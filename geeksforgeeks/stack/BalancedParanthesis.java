import java.util.*;

class BalancedParanthesis
{
    static boolean isBalanced(String s)
    {
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i<s.length(); i++ )
        {
            
            char ch = s.charAt(i);
            // push onto stack for opening brackets
            if( ch == '(' || ch == '['|| ch == '{' )
                stack.push(ch);
            
            else if (stack.isEmpty())
                return false;
            
            // pop for closing backets
            else if (isMatching(stack.peek(), ch))
                stack.pop();
            else
                return false;
            display(stack);
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }
    static boolean isMatching(char a, char b)
    {
        //System.out.println( "Matching "+a+" "+b);
        if((a=='(' && b == ')') ||
            (a == '{' && b == '}') ||
            (a =='[' && b == ']'))
            return true;

        return false;
    }
    static void display(Stack stack)
    {
        Iterator itr = stack.iterator();
        System.out.println("\nStack contents: ");
        while(itr.hasNext())
        {
            System.out.print(itr.next()+ " " );
        }
    }
    public static void main(String []args)
    {
        String s ="{}[()](())";
        System.out.println(isBalanced(s));
    }
}