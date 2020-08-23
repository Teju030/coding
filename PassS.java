import java.util.*;
public class PassS
{
    public static void main(String []args)
    {

        Set s = new HashSet<Integer>();
        s.add(10);
        s.add(5);
        s = new SortedSet(s);
        System.out.println("execec cught"+s);
        
    }
    void start()
    {
        String s1 = "slip";
        String s2 = fix(s1);
        System.out.println(s1+" "+s2);
    }
    String fix(String s1)
    {
        s1 = s1 + "stream";
        System.out.print(s1+" ");
        return "stream";
    }
}