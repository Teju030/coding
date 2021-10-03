import java.util.*;

class Program {
  public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
    // Write your code here.
		// forward pass
		// String []keys = blocks.get(0).getKeys();
		int dp[][] = new int[blocks.size()][reqs.length];
		
		final int DIST_CONST = blocks.size()+1;
		for(int i = 0; i<blocks.size(); i++){
			Map<String, Boolean> map = blocks.get(i);
			for(int j =0 ; j < reqs.length; j++){
				dp[i][j] = map.get(reqs[j]) ? 0 :DIST_CONST;
				if(i==0) continue;
				dp[i][j] = Math.min(dp[i-1][j] + 1 , dp[i][j]);
			}
		}
		
		int block_no = blocks.size()-1;
		int max_dist = DIST_CONST;
		// for(int j = 0 ; j<reqs.length; j++){
		// 		max_dist = Math.max(max_dist, dp[block_no][j]);
		// }
		for(int i = blocks.size()-1; i>=0; i--){
			Map<String, Boolean> map = blocks.get(i);
			
			int tmp_max_dist = -1;
			for(int j =0 ; j < reqs.length; j++){
				if(i < blocks.size()-1){
					dp[i][j] = Math.min(dp[i][j], dp[i+1][j]+1);
				}
				tmp_max_dist = Math.max(tmp_max_dist, dp[i][j]);
			}

			if(tmp_max_dist < max_dist)
			{
				max_dist = tmp_max_dist;
				block_no = i;
			}
		}

    return block_no;
  }
}
