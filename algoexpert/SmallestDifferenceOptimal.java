import java.util.*;

class Program {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int []res = new int[2];
		int min_diff = Integer.MAX_VALUE;
		int i = 0, j = 0;
		while(i < arrayOne.length && j < arrayTwo.length)
		{
				int diff = Math.abs(arrayOne[i] - arrayTwo[j]);
				if(diff < min_diff)
				{
						min_diff = diff;
						res[0] = arrayOne[i];
						res[1] = arrayTwo[j];
				}
				if( arrayOne[i] < arrayTwo[j])
				{
					i++;
				}
				else{
					j++;
				}
		}
		
		
    return res;
  }
}
