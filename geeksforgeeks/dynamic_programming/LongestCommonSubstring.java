import java.util.*;
import java.io.*;

class LongestCommonSubstring
{
    public static int longestCommonSubstringR(String s1, String s2, int m , int n, int max_len)
    {
        if(m < 0 || n < 0 )
            return 0;
        int cur_len =0;
        if(s1.charAt(m) == s2.charAt(n))
        {
            cur_len = longestCommonSubstringR(s1, s2, m-1, n-1, max_len+1) ; 
        }
        else
        {
            cur_len = Math.max(longestCommonSubstringR(s1, s2, m-1, n, 0), 
            longestCommonSubstringR(s1, s2, m, n-1, 0));
        }
        max_len = Math.max(cur_len, max_len);
        return max_len;
    }

    public static int longestCommonSubstring(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();

        int [][]dp = new int[m+1][n+1];
        int max_len = 0;
        for(int i=1; i<m+1; i++)
        {
            for(int j = 1; j<n+1; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] +1;
                    max_len = Math.max(max_len, dp[i][j]);
                }
            }
        }
        return max_len;
    }
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0)
		{
		    int size1 = sc.nextInt();
		    //char[] string1 = new char[size1];
		    int size2 = sc.nextInt();
		    //char[] string2 = new char[size2];
		    
		    String string1 = sc.next();
		    String string2 = sc.next();
		    System.out.println(longestCommonSubstring(string1, string2));
		}
    }
}