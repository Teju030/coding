class Solution {
    int count = 0;
    public int countArrangement(int n) {
        int []nums = new int[n];
        for(int i = 1; i<=n ; i++){
            nums[i-1] = i;
        }
        permute(nums, 0);
        return count;
    }
    public void permute(int []nums, int k){
        if( k == nums.length ) {
            count +=1;
            return;
        }
        for(int i = k; i<nums.length; i++){
            swap(nums, i, k );
            if(nums[k] % (k+1) == 0 || (k+1) % nums[k] == 0)
                permute(nums, k+1);
            swap(nums, i , k );
        }
    }
    
    public void swap(int []nums, int i, int j ){
        int tmp = nums[i];
        nums[i] =nums[j];
        nums[j] = tmp;
    }
}