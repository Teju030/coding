class Solution {
    public int maxArea(int[] height) {
        int max_area = 0;
        int left = 0 ;
        int right = height.length -1;
        
        while(left < right){
            if( height[left] < height[right])
            {
                int area = height[left] * Math.abs(left-right);
                max_area = Math.max(max_area, area);
                left++;
            }
            else{
                int area = height[right] * Math.abs(left-right);
                max_area = Math.max(max_area, area);
                right--;
            }
            
        }
                
        return max_area;
    }
}