import java.util.*;
import java.io.*;
// using bit masking approach
class CHEFCAKE
{
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    int n = sc.nextInt();
		    int[] a =new int[n];
		    int[] fact = new int[]{1,1,2,6,24,120,720,5040,40320,362880};
		    int[] digit = new int[]{0,1,11,111,1111,11111,111111,1111111,11111111,111111111};
		    long sum=0;
		    for(int i=0;i<n;i++)
		    {
		            a[i] = sc.nextInt();
		    }
		        
    		for(int i=0;i<n;i++)
    	    {
    		    sum += ((long)fact[n-1]*(long)a[i]*digit[n]);       
    	    }
		        
		        
		      System.out.println(sum);  
		}
	}
}