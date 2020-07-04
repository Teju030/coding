/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class LongestCommonSubsequence {
    public static int getLCSrecursive(String string1, String string2, int n, int m)
    {
        if( n == string1.length() || m == string2.length() ) 
            return 0;
        if(string1.charAt(n) == string2.charAt(m))
        {
            return 1 + getLCSrecursive(string1, string2, n+1, m+1);
        }
        
        return Math.max(getLCSrecursive(string1, string2, n+1, m), getLCSrecursive(string1, string2, n, m+1));
    }

    public static int getLCS(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<m+1; i++)
            dp[0][i] = 0;
        for(int i=0; i<n+1; i++)
            dp[i][0] = 0;
        for(int i=1; i<n+1;i++)
        {
            for(int j=1;j<m+1; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
	public static void main (String[] args) {
		//code
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
		    System.out.println(getLCS(string1, string2));
		}
	}
}