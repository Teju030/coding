class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []   
        subset = [] 
        length = len(nums)
        def helper( pos: int):
           # print(subset, pos)
            if pos == length:
                res.append(subset.copy())
                return 
            subset.append(nums[pos])
            helper(pos+1)
            subset.pop()
            helper(pos+1)
        helper(0)
        return res

