class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        
        int cnt = 0;
        for(int i = 0 ; i<nums.length; i++){
            if(!queue.isEmpty() && cnt == k){
                if(queue.peek()<nums[i]){
                    queue.remove();
                    queue.add(nums[i]);
                }
            }
            else{
                queue.add(nums[i]);
                cnt++;
            }
        }
        return queue.peek();
    }
}