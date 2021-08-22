import java.util.*;

class Program {
  public static int longestPeak(int[] array) {
    int n = array.length;
		int longestPeak = 0;
		int startPeak = 0;
		boolean wasIncreasing = false;

		for(int i = 1; i < n ; )
		{
			if(array[i-1] < array[i])
			{
				wasIncreasing = true;
				i++;
			}
			else if(array[i-1] == array[i])
			{
				wasIncreasing = false;
				startPeak = i;
				i++;
			}
			else
			{
				if(wasIncreasing)
				{
					while(i < n && array[i-1] > array[i])
					{
						longestPeak = Math.max(longestPeak, i - startPeak + 1);
						i++;
					}
					if( i<n && array[i-1] < array[i])
					{
						startPeak = i-1;
					}
					else
						startPeak = i; 
					wasIncreasing = false;
				}
				else
				{
					startPeak = i;
					i++;
				}
			}
		}
    return longestPeak;
  }
}
