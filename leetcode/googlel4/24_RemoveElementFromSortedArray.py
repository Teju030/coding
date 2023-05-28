class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        left = 1
        size = len(nums)
        
        for i in range(1, size):
            # found new element 
            if nums[i-1] != nums[i]:
                nums[left] = nums[i]
                left +=1
        
        return left