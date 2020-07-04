/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SubsetSum {
    // recursive solution   
    public static boolean getsubsetsumUtil(int[] in, int curr_sum, int sum, int n)
    {
        if(n == 0 ) return false;
        if(curr_sum == sum ) return true;
        return getsubsetsumUtil(in, curr_sum+in[n], sum, n-1) || getsubsetsumUtil(in, curr_sum, sum, n-1);
    }
    // DP solution 
    public static boolean getSubsetSum(int[] in, int sum)
    {
        int n = in.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i = 0; i<n+1; i++)
            dp[i][0] = true;
            
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<sum+1; j++)
            {
                if(in[i-1] <= j)
                    dp[i][j] = dp[i-1][j-in[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
    
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    int sum = 0;
		    for(int i =0; i<n ; i++)
		    {
		        arr[i] = sc.nextInt();
		        sum += arr[i];
		    }
		    if(sum%2 != 0)
		    {
		        System.out.println("NO");
		    }
		    else if(getSubsetSum(arr, sum/2))
		    {
		        System.out.println("YES");
		    }
		    else
		        System.out.println("NO");
		}
	}
}