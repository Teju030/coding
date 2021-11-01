class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left<right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) 
                return mid;
            else if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right = mid;
            }
                
        }
        
        return left;
    }
}

/*
0 1 2 3 
1 3 5 6

mid = 1
left = 1
right = 1


*/