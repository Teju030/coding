import java.util.*;

class Program {
  public static boolean isMonotonic(int[] array) {
    // Write your code here.
		if(array.length <= 1)
			return true;
		
		boolean isIncreasing = true;
		int i = 0;
		int j = 1;
		while(array[i] - array[j] <= 0)
		{
			i++;
			j++;
			if( j>=array.length) return true;
		}
		i = 0;
		j = 1;
		while(array[i] - array[j] >= 0)
		{
			i++;
			j++;
			if( j>=array.length) return true;
		}
    return false;
  }
}
