import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i< array.length; i++)
		{
			map.put(array[i], i);
		}
		int res[] = new int[2];
		for( int i = 0; i<array.length; i++)
		{
			int other = targetSum - array[i];
			res[0] = array[i];
			if(map.containsKey(other) && map.get(other)!=i){
				res[1] = other;
				return res;
			}
		}
    return new int[0];
  }
}
