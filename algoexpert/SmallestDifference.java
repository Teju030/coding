import java.util.*;

class Program {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int []res = new int[2];
		int min_diff = Integer.MAX_VALUE;
		for(int i = 0; i < arrayOne.length; i++)
		{
					for(int j = 0; j<arrayTwo.length; j++)
					{
						int diff = Math.abs(arrayOne[i] - arrayTwo[j]);
						if( diff < min_diff)
						{
							min_diff = diff;
							res[0] = arrayOne[i];
							res[1] = arrayTwo[j];
						}
					}
		}
		
    return res;
  }
}
