class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int n = nums.length;
        int cur = 0;
        for(int i = 0; i< nums.length; i++)
        {
            cur += nums[i];
            if( max_sum < cur){
                max_sum = cur; 
            }
            if(cur < 0)
                cur = 0;
        }
        return max_sum;
    }
}