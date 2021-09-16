class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if( n == 1) return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
        
        int dp[][] = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
        for(int i = 1; i<n; i++){
            for(int j = 0; j < 3; j++){
                dp[i][j] = costs[i][j] + Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
            }
        }
        
        return Math.min(Math.min( dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }
}