class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int []result = new int[n];
        int negative = 0;
        int positive = n-1;
        
        for(int i = n-1; i>=0; i--){
            int square = 0;
            if(Math.abs(nums[negative]) > nums[positive]){
                square = nums[negative]*nums[negative];
                negative++;
            }
            else{
                square = nums[positive]*nums[positive];
                positive--;
            }
            
            result[i] = square;
        }
        return result;
    }
}