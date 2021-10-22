class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int total_arr = 0;
        int prefix = 0;
        map.put(0, 1);
        for(int i = 0; i<nums.length; i++){
            prefix += nums[i];
            int tmp = prefix - k; 
            
            total_arr += map.getOrDefault(tmp, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            
            
        }
        return total_arr;
    }
}