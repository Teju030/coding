class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        elif n == 2:
            return max(nums[0], nums[1])

        amount = [0 for _ in range(n)]

        # assume first house is robbed 
        
        first = 0 
        amount[0] = nums[0]
        for i in range(1, n-1):
            amount[i] = max(first + nums[i], amount[i-1])
            first = amount[i-1] 

        max_amount = amount[n-2]
        # assume last house is robbed 
        last = 0
        amount[n-1] = nums[n-1]
        for i in range(n-2, 0, -1):
            amount[i] = max(last + nums[i], amount[i+1])
            last = amount[i+1]

        max_amount = max(max_amount, amount[1])
        return max_amount