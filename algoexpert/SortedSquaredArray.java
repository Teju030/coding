import java.util.*;

class Program {

  public int[] sortedSquaredArray(int[] array) {
    // Write your code here.
		for( int i = 0; i < array.length; i++)
		{
			array[i] = array[i]*array[i];
		}
		
		// sorting using quick sort 
		Arrays.sort(array);
		
		return array;
  }
}
