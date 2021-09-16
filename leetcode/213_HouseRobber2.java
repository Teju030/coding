class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0 ) return 0;
        if(n == 1) return nums[0];
        else if( n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robber(nums, 0, n-1), robber(nums, 1, n));
     
    }
    
    int robber(int []nums, int start, int end){
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i = start; i<end; i++){
            int max = Integer.MIN_VALUE;
            for( int j = start; j < i-1; j++){
                max = Math.max(max, dp[j]);
            }
            dp[i] = Math.max(nums[i], nums[i] + max);
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i = start; i<end; i++)
        {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    
}