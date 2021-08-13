class Solution {
    public void nextPermutation(int[] nums) {
     // find the greater number from left 
        int n = nums.length;
        int start = 0;
        int last = n -1;
        for( int i = n-2; i >= 0; i--)
        {
            if( nums[i] < nums[i+1]){
                start = i;
                
                for(int j = last; j >= start; j--)
                {
                    if(nums[j] > nums[start])
                    {
                        int tmp = nums[j];
                        nums[j] = nums[start];
                        nums[start] = tmp;
                        start++;
                        break;
                    }
                }
                
                break;
            }
        }
        //System.out.println("Res: " + Arrays.toString(nums));
        
        // Inplace reverse remaining array
        int l = start;
        int r = last;
        while(l < r)
        {
            // swap 
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }

    }
}