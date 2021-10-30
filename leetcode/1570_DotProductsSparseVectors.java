class SparseVector {
    Map<Integer, Integer> map = new HashMap<Integer, Integer> ();
    
    SparseVector(int[] nums) {
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                map.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int ans = 0;
        for(int i : this.map.keySet()){
            if(vec.map.containsKey(i)){
                ans += this.map.get(i)*vec.map.get(i);
            }
        }
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);