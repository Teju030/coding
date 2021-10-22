class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // nj = a * k + b
        // ni = c * k + d 
        // sum(nums[i:j]) = (c - a) % k + (b - d)
        // we want b = d

        HashMap<Integer, Integer> map = new HashMap<>();
        int []remaineders = new int[nums.length];
        int n = nums.length;
        int rem = 0;
        map.put(0,-1);
        for(int i = 0; i < n ; i++){
           
            rem += nums[i];
            if(k != 0 ) rem %= k;
            if( map.get(rem) != null)
            { if(i - map.get(rem) > 1)
                return true;
            }
            else{
                 map.put(rem, i);
            }
               
        }
        
        return false;

    }
}