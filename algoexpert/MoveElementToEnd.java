import java.util.*;

class Program {
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    // Write your code here.
		int start  = 0;
		int last = array.size()-1;
		while(start < last )
		{
				if( array.get(start) == toMove )
				{
					if( array.get(last) != toMove ){
						// swap 
						int tmp = array.get(last);
						array.set(last, array.get(start));
						array.set(start, tmp);
						start++;
					}else{
						last--;
					}
				}
				else
					start++;
		}
    return array;
  }
}
