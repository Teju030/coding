class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        
        int res[] = new int[n];
        
        for(int i = n-2; i >= 0; i--)
        {
            if(nums[i] == 0)
            {
                res[i] = Integer.MAX_VALUE;
            }
            else
            {
                int j = i+1; 
                int max_jump = i + nums[i];
                int min_val = Integer.MAX_VALUE;
                while ( j < n && j <= max_jump)
                {
                    min_val = Math.min(min_val, res[j]);
                    j++;
                }
                if(min_val == Integer.MAX_VALUE) 
                    res[i] = min_val;
                else
                    res[i] = min_val + 1;
                
              //  System.out.println("Res:" + Arrays.toString(res));
            }
            
        }
        return res[0];
    }
}