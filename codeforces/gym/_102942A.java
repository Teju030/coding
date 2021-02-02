import java.util.*;
// https://codeforces.com/gym/102942/problem/A
public class _102942A
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // char direct[][] = {
        //     { 'E', 'W'}, // North 0
        //     { 'N', 'S'}, // West 1
        //     { 'W', 'E'}, // South 2
        //     { 'S', 'N'} // East 3
        // }
        int direct[][] = {
            { 3, 1}, // North 0
            { 0, 2}, // West 1
            { 1, 3}, // South 2
            { 2, 0} // East 3
        };
        char direction[] = { 'N', 'W', 'S', 'E'};

        while(t-- > 0)
        {
            int n = sc.nextInt();
            sc.nextLine();
            String in = sc.nextLine();
            String []d = in.split("");
            int face = 3;
            for(int i = 0 ;i < n; i++)
            {
                int l = Integer.parseInt(d[i]);
                face = direct[face][l];
            }

            System.out.println(direction[face]);
        }
    }
}