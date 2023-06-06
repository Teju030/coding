class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        minL = float('inf')
        left, right = 0, 0
        curr = 0
        while right < len(nums):
            curr += nums[right]
            while curr >= target:
                minL = min(minL, right - left + 1)
                curr -= nums[left]
                left +=1
            right += 1
        return 0 if minL == float('inf') else minL