import java.util.*;

class Program {

  public int nonConstructibleChange(int[] coins) {
    // Write your code here.
		Arrays.sort(coins);
		int already_have = 0;
		int new_val = 0;
		for(int i = 0; i<coins.length; i++)
		{
				int val = coins[i];
				new_val = already_have + 1;
				if(val > new_val){
					return new_val;
				}
				already_have += val;
		}
		return already_have + 1 ;
  }
}
