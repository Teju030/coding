class Solution {

    public int search(int[] nums, int target) {
        // find the pivot element
        int n = nums.length;
        int l = 0;
        int r = nums.length-1;
        int pivot = findPivot(nums, l, r);
        System.out.println(pivot);
        // check if target in first half;
        if(nums[pivot] <= target && target<=nums[n-1])
        {
            return binarySearch(nums, pivot, n-1, target);
            
        }
        else{
            return binarySearch(nums, 0, pivot-1, target);
        }
            
    }
    public int findPivot(int []nums, int l, int r){
        
        while(l < r){
            
            int mid = l + ( r - l ) / 2;
            
            if( nums[mid] > nums[r] )
            {
                l = mid+1;
            }
            else{
                r = mid;
            }
        }   
        return l;
    }
    public int binarySearch(int[] nums, int l, int r, int target)
    {
        int index = -1;
        while(l <= r){
            
            int mid = l + ( r - l ) / 2;
            
            if( nums[mid] == target )
            {
                index = mid;
                break;
            }
            else if(target< nums[mid] )
            {
                r = mid -1;
            }
            else{
                l = mid + 1;
            }
        } 
        return index;
    }
}