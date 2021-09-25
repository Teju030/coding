class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i = 0; i<n ; i++){
            total += nums[i];
        }
        if(total % 2 != 0) return false;
        total /=2;
        boolean dp[][] = new boolean[n+1][total+1];
        
        for(int i =0 ;i <= n; i++)
        {
            dp[i][0] = true;
        }
        
        for(int i = 1; i<= n; i++){
            for( int j = 1; j<=total; j++){
                if(nums[i-1] <= j)
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][total];
    }
    
    
}