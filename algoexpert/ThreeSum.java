import java.util.*;

class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
		ArrayList<Integer[]> res = new ArrayList<>();
		HashMap <Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < array.length; i++)
		{
			map.put(array[i], i);
		}
		for(int i = 0; i < array.length; i++)
		{
			int tmp_sum = targetSum - array[i];
			for( int j = i+1; j< array.length; j++)
			{
				int diff = tmp_sum - array[j];
				if(map.containsKey(diff) && map.get(diff) > i && map.get(diff) > j)
				{
					Integer[] tmp_array = {array[i], array[j], diff};
					Arrays.sort(tmp_array);
					res.add(tmp_array);
				}
			}
		}
		Collections.sort(res, new Comparator<Integer[]>() {
			public int compare(Integer[] a, Integer[] b) {
					if(a[0] - b[0] != 0)  return (a[0] - b[0]);
					else if( a[1] - b[1] != 0) return ( a[1] - b[1]);
					else if( a[2] - b[2] != 0) return ( a[2] - b[2]);
				return 0;
    	}
		});
    return res;
  }
}
