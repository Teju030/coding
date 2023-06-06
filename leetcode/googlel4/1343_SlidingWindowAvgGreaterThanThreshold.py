class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        total = 0
        left = 0
        curr = 0
        for right in range(len(arr)):
            curr+= arr[right]
            if right - left + 1 == k:
                total = total +1 if (curr/k) >= threshold else total
                curr -= arr[left]
                left +=1

        return total